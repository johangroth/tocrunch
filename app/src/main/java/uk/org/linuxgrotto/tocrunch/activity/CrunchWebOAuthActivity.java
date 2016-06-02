package uk.org.linuxgrotto.tocrunch.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.DuplicateConnectionException;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.connect.CrunchConnectionFactory;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchWebOAuthActivity extends AbstractWebViewActivity {
    private static final String TAG = CrunchWebOAuthActivity.class.getSimpleName();

    private static final String REQUEST_TOKEN_KEY = "request_token";

    private static final String REQUEST_TOKEN_SECRET_KEY = "request_token_secret";

    private ConnectionRepository connectionRepository;

    private CrunchConnectionFactory connectionFactory;

    private SharedPreferences crunchPreferences;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.connectionRepository = getApplicationContext().getConnectionRepository();
        this.connectionFactory = getApplicationContext().getCrunchConnectionFactory();
        this.crunchPreferences = getSharedPreferences("CrunchConnectPreferences", Context.MODE_PRIVATE);
    }

    @Override
    public void onStart() {
        super.onStart();
        Uri uri = getIntent().getData();
        if (uri != null) {
            String oauthVerifier = uri.getQueryParameter("oauth_verifier");

            if (oauthVerifier != null) {
                getWebView().clearView();
                new CrunchPostConnectTask().execute(oauthVerifier);
            }
        } else {
            new CrunchPreConnectTask().execute();
        }
    }


    // ***************************************
    // Private methods
    // ***************************************
    private String getOAuthCallbackUrl() {
        return getApplicationContext().getCrunchOAuthUrls().getCallbackUrl();
    }

    private void displayCrunchAuthorization(OAuthToken requestToken) {
        // save for later use
        saveRequestToken(requestToken);

        // Generate the Crunch authorization URL to be used in the browser or web view
        String authUrl = this.connectionFactory.getOAuthOperations().buildAuthorizeUrl(requestToken.getValue(), OAuth1Parameters.NONE);

        // display the crunch authorization screen
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl));
        intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(intent);
        finish();
    }

    private void displayCrunchOptions() {
        Intent intent = new Intent();
        intent.setClass(this, CrunchActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveRequestToken(OAuthToken requestToken) {
        SharedPreferences.Editor editor = this.crunchPreferences.edit();
        editor.putString(REQUEST_TOKEN_KEY, requestToken.getValue());
        editor.putString(REQUEST_TOKEN_SECRET_KEY, requestToken.getSecret());
        editor.commit();
    }

    private OAuthToken retrieveRequestToken() {
        String token = this.crunchPreferences.getString(REQUEST_TOKEN_KEY, null);
        String secret = this.crunchPreferences.getString(REQUEST_TOKEN_SECRET_KEY, null);
        return new OAuthToken(token, secret);
    }

    private void deleteRequestToken() {
        this.crunchPreferences.edit().clear().commit();
    }

    // ***************************************
    // Private classes
    // ***************************************
    private class CrunchPreConnectTask extends AsyncTask<Void, Void, OAuthToken> {

        @Override
        protected void onPreExecute() {
            showProgressDialog("Initializing OAuth Connection...");
        }

        @Override
        protected OAuthToken doInBackground(Void... params) {
            // Fetch a one time use Request Token from Crunch App
            return connectionFactory.getOAuthOperations().fetchRequestToken(getOAuthCallbackUrl(), null);
        }

        @Override
        protected void onPostExecute(OAuthToken requestToken) {
            dismissProgressDialog();
            displayCrunchAuthorization(requestToken);
        }

    }

    protected class CrunchPostConnectTask extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            showProgressDialog("Finalizing OAuth Connection...");
        }

        @Override
        protected Void doInBackground(String... params) {
            if (params.length <= 0) {
                return null;
            }

            final String verifier = params[0];

            OAuthToken requestToken = retrieveRequestToken();

            // Authorize the Request Token
            AuthorizedRequestToken authorizedRequestToken = new AuthorizedRequestToken(requestToken, verifier);

            // Exchange the Authorized Request Token for the Access Token
            OAuthToken accessToken = connectionFactory.getOAuthOperations().exchangeForAccessToken(authorizedRequestToken, null);

            deleteRequestToken();

            // Persist the connection and Access Token to the repository
            Connection<Crunch> connection = connectionFactory.createConnection(accessToken);

            try {
                connectionRepository.addConnection(connection);
            } catch (DuplicateConnectionException e) {
                Log.e(TAG, "connection already exists in repository!");
                // connection already exists in repository!
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            dismissProgressDialog();
            displayCrunchOptions();
        }

    }
}

package uk.org.linuxgrotto.tocrunch.oauth;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import org.springframework.security.crypto.encrypt.AndroidEncryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.sqlite.SQLiteConnectionRepository;
import org.springframework.social.connect.sqlite.support.SQLiteConnectionRepositoryHelper;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;

/**
 * Created by jgroth on 22/03/16.
 */
public class OAuthSandbox extends CrunchCommonApiV2 {

    public static final String CONSUMER_KEY = "too_crunch";
    public static final String SHARED_SECRET ="c376e7dc-b040-4bdf-82ed-28a32d123f41";

    private static final String OAUTH_BASE_URL = "https://demo.crunch.co.uk";
    private static final String API_BASE_URL = "https://sandbox.api.crunch.co.uk/rest/v2/";
    private static final String CALLBACK_URL = "too_crunch://authorise";

    private Context context;

    private ConnectionFactoryRegistry connectionFactoryRegistry;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private ConnectionRepository connectionRepository;

    public OAuthSandbox() {}

    public OAuthSandbox(Context context) {
        this.context = context;
    }

    public static String getRequestTokenEndpoint() {
        return OAUTH_BASE_URL + REQUEST_TOKEN;
    }

    public static String getAccessTokenEndpoint() {
        return OAUTH_BASE_URL + ACCESS_TOKEN;
    }

    public static String getAuthorizationEndpoint() {

        return OAUTH_BASE_URL + AUTHORIZE;
    }

    public static String getCallbackUrl() {
        return CALLBACK_URL;
    }

    @Override
    public String getApiBaseUrl() {
        return API_BASE_URL;
    }

    public void setupConnectionFactory() {
        connectionFactoryRegistry = new ConnectionFactoryRegistry();
        CrunchConnectionFactory crunchConnectionFactory = new CrunchConnectionFactory(CONSUMER_KEY, SHARED_SECRET);
        connectionFactoryRegistry.addConnectionFactory(crunchConnectionFactory);

        // Create the SQLiteOpenHelper for creating the local database
        sqLiteOpenHelper = new SQLiteConnectionRepositoryHelper(context);

        // The connection repository takes a TextEncryptor as a parameter for encypting the OAuth information
        TextEncryptor textEncryptor = AndroidEncryptors.noOpText();

        // Create the connection repository
        connectionRepository = new SQLiteConnectionRepository(sqLiteOpenHelper, connectionFactoryRegistry, textEncryptor);

        CrunchConnectionFactory connectionFactory = (CrunchConnectionFactory) connectionFactoryRegistry.getConnectionFactory(Crunch.class);

        OAuth1Operations oAuth1Operations = connectionFactory.getOAuthOperations();
        OAuthToken requestToken = oAuth1Operations.fetchRequestToken(OAuthSandbox.CALLBACK_URL, null);

        String authoriseUrl = oAuth1Operations.buildAuthorizeUrl(requestToken.getValue(), OAuth1Parameters.NONE);

        /**
         *  <activity android:name="uk.org.linuxgrotto.tocrunch.activity.CrunchActivity">
         <intent-filter>
         <action android:name="android.intent.action.VIEW" />
         <category android:name="android.intent.category.DEFAULT" />
         <category android:name="android.intent.category.BROWSABLE" />
         <data android:scheme="too_crunch" android:host="authorise" />
         </intent-filter>
         </activity>
         */
        Uri uri = Uri.EMPTY;
        String oauthVerifier = uri.getQueryParameter("oauth_verifier");

        AuthorizedRequestToken authorizedRequestToken = new AuthorizedRequestToken(requestToken, oauthVerifier);
        OAuth1Operations oauth = connectionFactory.getOAuthOperations();
        OAuthToken accessToken = oauth.exchangeForAccessToken(authorizedRequestToken, null);

        Connection<Crunch> connection = connectionFactory.createConnection(accessToken);
        connectionRepository.addConnection(connection);

    }
}

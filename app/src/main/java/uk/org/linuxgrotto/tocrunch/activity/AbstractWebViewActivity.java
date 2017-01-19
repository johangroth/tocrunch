package uk.org.linuxgrotto.tocrunch.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uk.org.linuxgrotto.tocrunch.oauth.MainApplication;

/**
 * Created by jgroth on 04/04/16.
 */
public class AbstractWebViewActivity extends AppCompatActivity implements AsyncActivity {

    protected static final String TAG = AbstractWebViewActivity.class.getSimpleName();

    private Activity activity;

    private WebView webView;

    private ProgressDialog progressDialog = null;

    private boolean destroyed = false;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public MainApplication getApplicationContext() {
        return (MainApplication) super.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        this.webView = new WebView(this);
        setContentView(this.webView);
        this.activity = this;

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                if (uri.getScheme().equals("to-crunch")) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(uri);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e(TAG, "Could not load url "+ url);
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

    }

    // ***************************************
    // Protected methods
    // ***************************************
    protected WebView getWebView() {
        return webView;
    }

    // ***************************************
    // Public methods
    // ***************************************
    public void showLoadingProgressDialog() {
        showProgressDialog("Loading. Please wait...");
    }

    public void showProgressDialog(CharSequence message) {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setIndeterminate(true);
        }

        this.progressDialog.setMessage(message);
        this.progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (this.progressDialog != null && !this.destroyed) {
            this.progressDialog.dismiss();
        }
    }

}

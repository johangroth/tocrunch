package uk.org.linuxgrotto.tocrunch.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

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
        /*getWindow().requestFeature(Window.FEATURE_PROGRESS);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        this.webView = new WebView(this);
        setContentView(this.webView);
        this.activity = this;

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setTitle("Loading...");
                activity.setProgress(progress * 100);
                if (progress == 100) {
                    activity.setTitle(R.string.app_name);
                }
            }
        });*/
    }

    // ***************************************
    // Protected methods
    // ***************************************
    protected WebView getWebView() {
        return this.webView;
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

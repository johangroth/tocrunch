package uk.org.linuxgrotto.tocrunch.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.org.linuxgrotto.tocrunch.oauth.MainApplication;

/**
 * Created by jgroth on 04/04/16.
 */
public class AbstractWebViewActivity extends AppCompatActivity implements AsyncActivity {

    protected static final String TAG = AbstractWebViewActivity.class.getSimpleName();

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

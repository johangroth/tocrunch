package uk.org.linuxgrotto.tocrunch.activity;

import uk.org.linuxgrotto.tocrunch.oauth.MainApplication;

/**
 * Created by jgroth on 04/04/16.
 */
public interface AsyncActivity {

    MainApplication getApplicationContext();

    void showLoadingProgressDialog();

    void showProgressDialog(CharSequence message);

    void dismissProgressDialog();

}

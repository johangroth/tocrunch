package uk.org.linuxgrotto.tocrunch.oauth;

/**
 * Created by jgroth on 04/04/16.
 */
public interface AsyncActivity {

    public MainApplication getApplicationContext();

    public void showLoadingProgressDialog();

    public void showProgressDialog(CharSequence message);

    public void dismissProgressDialog();

}

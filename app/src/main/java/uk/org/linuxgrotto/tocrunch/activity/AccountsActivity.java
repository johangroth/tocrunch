package uk.org.linuxgrotto.tocrunch.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import uk.org.linuxgrotto.tocrunch.R;

/**
 * Created by jgroth on 03/06/16.
 */
public class AccountsActivity extends FragmentActivity {

    private static final String TAG = AccountsActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
    }

}

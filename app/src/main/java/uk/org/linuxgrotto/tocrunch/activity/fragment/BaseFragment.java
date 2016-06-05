package uk.org.linuxgrotto.tocrunch.activity.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;

/**
 * Created by jgroth on 05/06/16.
 */
public class BaseFragment extends Fragment {
    private ProgressDialog progressDialog;
    private boolean destroyed = false;

    // ***************************************
    // Public methods
    // ***************************************
    public void showLoadingProgressDialog() {
        showProgressDialog("Loading. Please wait...");
    }

    public void showProgressDialog(CharSequence message) {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(getActivity());
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

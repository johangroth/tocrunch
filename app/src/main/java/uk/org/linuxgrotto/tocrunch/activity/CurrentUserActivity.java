package uk.org.linuxgrotto.tocrunch.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.model.Director;

/**
 * Created by jgroth on 05/06/16.
 */
public class CurrentUserActivity extends AbstractAsynchListActivity {
    private static final String TAG = CurrentUserActivity.class.getSimpleName();

    private Crunch crunch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crunch = getApplicationContext().getConnectionRepository().findPrimaryConnection(Crunch.class).getApi();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new FetchCurrentUserTask().execute();
    }

    private void showResult(Director director) {
        if (director != null) {
            CurrentUserListAdapter currentUserListAdapter = new CurrentUserListAdapter(this, director);
            setListAdapter(currentUserListAdapter);
        }
    }

    private class FetchCurrentUserTask extends AsyncTask<Void, Void, Director> {
        @Override
        protected void onPreExecute() {
            showProgressDialog("Fetching Current user");
        }

        @Override
        protected Director doInBackground(Void... params) {
            try {
                return crunch.currentUserOperations().getCurrentUser();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Director director) {
            dismissProgressDialog();
            showResult(director);
        }
    }
}

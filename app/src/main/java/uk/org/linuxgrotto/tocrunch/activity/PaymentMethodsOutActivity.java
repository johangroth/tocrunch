package uk.org.linuxgrotto.tocrunch.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethods;

/**
 * Created by jgroth on 05/06/16.
 */
public class PaymentMethodsOutActivity extends AbstractAsynchListActivity {

    private static final String TAG = PaymentMethodsOutActivity.class.getSimpleName();

    private Crunch crunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crunch = getApplicationContext().getConnectionRepository().findPrimaryConnection(Crunch.class).getApi();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new FetchPaymentMethodsOut().execute();
    }

    private void showResults(PaymentMethods paymentMethods) {
        if (paymentMethods != null) {
            PaymentMethodsOutListAdapter paymentMethodsListAdapter = new PaymentMethodsOutListAdapter(this, paymentMethods);
            setListAdapter(paymentMethodsListAdapter);
        }
    }

    private class FetchPaymentMethodsOut extends AsyncTask<Void, Void, PaymentMethods> {
        @Override
        protected void onPreExecute() {
            showProgressDialog("Fetching PaymentMethods");
        }

        @Override
        protected PaymentMethods doInBackground(Void... voids) {
            try {
                return crunch.paymentMethodOperations().getPaymentMethodOut();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(PaymentMethods paymentMethods) {
            dismissProgressDialog();
            showResults(paymentMethods);
        }
    }
}

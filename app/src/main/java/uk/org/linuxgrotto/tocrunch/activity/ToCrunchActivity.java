package uk.org.linuxgrotto.tocrunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.springframework.social.connect.ConnectionRepository;

import uk.org.linuxgrotto.tocrunch.R;
import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.connect.CrunchConnectionFactory;

public class ToCrunchActivity extends AbstractAsyncActivity {

    private static final String TAG = ToCrunchActivity.class.getSimpleName();

    private ConnectionRepository connectionRepository;

    private CrunchConnectionFactory connectionFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crunch);
        connectionRepository = getApplicationContext().getConnectionRepository();
        connectionFactory = getApplicationContext().getCrunchConnectionFactory();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isConnected()) {
            showCrunchOptions();
        } else {
            showConnectOptions();
        }
    }

    private boolean isConnected() {
        return connectionRepository.findPrimaryConnection(Crunch.class) != null;
    }

    private void disconnect() {
        this.connectionRepository.removeConnections(this.connectionFactory.getProviderId());
    }

    private void showConnectOptions() {
        String[] options = {"Connect"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        ListView listView = (ListView) this.findViewById(R.id.tocrunch_activity_options_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentView, View childView, int position, long id) {
                switch (position) {
                    case 0:
                        displayCrunchAuthorisation();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void showCrunchOptions() {
        String[] options = {"Logout", "Accounts", "Expense types", "Payment methods in", "Payment methods out",
        "Current User"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        ListView listView = (ListView) this.findViewById(R.id.tocrunch_activity_options_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parentView, View childView, int position, long id) {
                switch (position) {
                    case 0:
                        disconnect();
                        showConnectOptions();
                        break;
                    case 1:
                        startActivity(new Intent(parentView.getContext(), AccountsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(parentView.getContext(), ExpenseTypesActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(parentView.getContext(), PaymentMethodsInActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(parentView.getContext(), PaymentMethodsOutActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(parentView.getContext(), CurrentUserActivity.class));
                }

            }
        });
    }

    private void displayCrunchAuthorisation() {
        startActivity(new Intent(this, ToCrunchWebOAuthActivity.class));
        finish();
    }
}

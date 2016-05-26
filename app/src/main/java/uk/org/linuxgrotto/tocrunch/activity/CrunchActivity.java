package uk.org.linuxgrotto.tocrunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.springframework.social.connect.ConnectionRepository;

import uk.org.linuxgrotto.tocrunch.R;
import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.connect.CrunchConnectionFactory;

public class CrunchActivity extends AbstractAsyncActivity {

    private static final String TAG = CrunchActivity.class.getSimpleName();

    private ConnectionRepository connectionRepository;

    private CrunchConnectionFactory connectionFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate invoked");
        setContentView(R.layout.activity_crunch);
        connectionFactory = getApplicationContext().getCrunchConnectionFactory();
        connectionRepository = getApplicationContext().getConnectionRepository();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart invoked");
        if (!isConnected()) {
            showConnectOptions();
        }
    }

    private boolean isConnected() {
        return connectionRepository.findPrimaryConnection(Crunch.class) != null;
    }

    private void showConnectOptions() {
        String[] options = {"Connect"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        ListView listView = (ListView) this.findViewById(R.id.crunch_activity_options_list);
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

    private void displayCrunchAuthorisation() {
        startActivity(new Intent(this, CrunchWebOAuthActivity.class));
        finish();
    }
}

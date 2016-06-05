package uk.org.linuxgrotto.tocrunch.activity.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import uk.org.linuxgrotto.tocrunch.R;
import uk.org.linuxgrotto.tocrunch.activity.adapter.AccountExpandableAdapter;
import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.model.Accounts;
import uk.org.linuxgrotto.tocrunch.api.model.AccountsParent;
import uk.org.linuxgrotto.tocrunch.oauth.MainApplication;

/**
 * Created by jgroth on 05/06/16.
 */
public class AccountsFragment extends BaseFragment {
    private static final String TAG = AccountsFragment.class.getSimpleName();

    private Crunch crunch;
    private RecyclerView recyclerView;
    private AccountExpandableAdapter accountExpandableAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crunch = MainApplication.crunch;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_account_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        new FetchAccounts().execute();
        return view;
    }

    private class FetchAccounts extends AsyncTask<Void, Void, Accounts> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog("Fetching Expense types");
        }

        @Override
        protected Accounts doInBackground(Void... voids) {
            try {
                return crunch.accountOperations().getAccounts();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Accounts accounts) {
            dismissProgressDialog();
            if (isAdded()) {
                accountExpandableAdapter = new AccountExpandableAdapter(getActivity(), generateAccountsParentList(accounts));
            }
            recyclerView.setAdapter(accountExpandableAdapter);
        }

        private List<ParentListItem> generateAccountsParentList(Accounts accounts) {
            List<ParentListItem> parentListItems = new ArrayList<>();
            AccountsParent accountsParent = new AccountsParent();
            accountsParent.setAccountType("Bank accounts");
            accountsParent.setChildItemList(accounts.getBankAccounts());
            parentListItems.add(accountsParent);

            accountsParent = new AccountsParent();
            accountsParent.setAccountType("Credit cards");
            accountsParent.setChildItemList(accounts.getCreditCards());
            parentListItems.add(accountsParent);

            accountsParent = new AccountsParent();
            accountsParent.setAccountType("Payment processing accounts");
            accountsParent.setChildItemList(accounts.getPaymentProcessingAccounts());
            parentListItems.add(accountsParent);

            return parentListItems;
        }
    }
}

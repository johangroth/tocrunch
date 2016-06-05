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
import uk.org.linuxgrotto.tocrunch.activity.adapter.ExpenseGroupExpandableAdapter;
import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseGroup;
import uk.org.linuxgrotto.tocrunch.oauth.MainApplication;

public class ExpenseTypesFragment extends BaseFragment {
    private static final String TAG = ExpenseTypesFragment.class.getSimpleName();

    private Crunch crunch;

    private ExpenseGroupExpandableAdapter expenseTypesAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crunch = MainApplication.crunch;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_expensetypes_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        new FetchExpenseTypes().execute();
        return view;
    }

    private class FetchExpenseTypes extends AsyncTask<Void, Void, List<ExpenseGroup>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog("Fetching Expense types");
        }

        @Override
        protected List<ExpenseGroup> doInBackground(Void... voids) {
            try {
                return crunch.expenseTypeOperations().getExpenseTypes().getExpenseGroup();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ExpenseGroup> expenseGroup) {
            dismissProgressDialog();
            if (isAdded()) {
                expenseTypesAdapter = new ExpenseGroupExpandableAdapter(getActivity(), generateExpenseGroupParentList(expenseGroup));
            }
            recyclerView.setAdapter(expenseTypesAdapter);
        }

        private List<ParentListItem> generateExpenseGroupParentList(List<ExpenseGroup> expenseGroups) {
            List<ParentListItem> parentListItems = new ArrayList<>();
            parentListItems.addAll(expenseGroups);
            return parentListItems;
        }
    }
}

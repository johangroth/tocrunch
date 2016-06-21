package uk.org.linuxgrotto.tocrunch.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import java.util.List;

import uk.org.linuxgrotto.tocrunch.R;
import uk.org.linuxgrotto.tocrunch.api.model.Account;
import uk.org.linuxgrotto.tocrunch.api.model.AccountsParent;

/**
 * Created by jgroth on 05/06/16.
 */
public class AccountExpandableAdapter extends ExpandableRecyclerAdapter<AccountExpandableAdapter.AccountParentViewHolder, AccountExpandableAdapter.AccountChildViewHolder> {

    private Context context;
    private LayoutInflater inflater;

    public AccountExpandableAdapter(Context context, List<ParentListItem> parentListItems) {
        super(parentListItems);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AccountParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.expandable_list, parentViewGroup, false);
        return new AccountParentViewHolder(view);
    }

    @Override
    public AccountChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.list_item_account_type, childViewGroup, false);
        return new AccountChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(AccountParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        AccountsParent accountsParent = (AccountsParent) parentListItem;
        parentViewHolder.titleTextView.setText(accountsParent.getAccountType());
    }

    @Override
    public void onBindChildViewHolder(AccountChildViewHolder childViewHolder, int position, Object childListItem) {
        Account account = (Account) childListItem;
        childViewHolder.accountTypeText.setText(account.getAccount());
        childViewHolder.accountNumberText.setText(account.getAccountNumber());
    }

    public class AccountParentViewHolder extends ToCrunchParentViewHolder {

        public AccountParentViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class AccountChildViewHolder extends ChildViewHolder {
        public TextView accountTypeText;
        public TextView accountNumberText;

        public AccountChildViewHolder(View itemView) {
            super(itemView);
            accountTypeText = (TextView) itemView.findViewById(R.id.child_list_item_account_type_text_view);
            accountNumberText = (TextView) itemView.findViewById(R.id.child_list_item_account_number_text_view);
        }
    }
}

package uk.org.linuxgrotto.tocrunch.api.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by jgroth on 05/06/16.
 */
public class AccountsParent implements ParentListItem {

    private String accountType;

    private List<Account> accounts;

    @Override
    public List<?> getChildItemList() {
        return accounts;
    }

    public void setChildItemList(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

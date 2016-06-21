package uk.org.linuxgrotto.tocrunch.api.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

public class ExpenseGroup implements ParentListItem {

    protected List<ExpenseType> expenseTypes;
    protected int count;
    protected String groupName;
    protected String displayName;

    public List<ExpenseType> getExpenseTypes() {
        if (expenseTypes == null) {
            expenseTypes = new ArrayList<>();
        }
        return this.expenseTypes;
    }

    @Override
    public List<?> getChildItemList() {
        return expenseTypes;
    }

    public void setChildItemList(List<ExpenseType> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String value) {
        this.groupName = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String value) {
        this.displayName = value;
    }

}

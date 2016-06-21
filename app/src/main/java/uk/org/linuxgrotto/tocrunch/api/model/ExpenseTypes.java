package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypes {

    protected List<ExpenseGroup> expenseGroup;

    protected int count;


    public List<ExpenseGroup> getExpenseGroup() {
        if (expenseGroup == null) {
            expenseGroup = new ArrayList<>();
        }
        return this.expenseGroup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

}

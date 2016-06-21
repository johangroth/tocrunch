package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;


public class Expenses extends ApiQueryList {

    protected List<Expense> expense;

    public List<Expense> getExpense() {
        if (expense == null) {
            expense = new ArrayList<Expense>();
        }
        return this.expense;
    }

}

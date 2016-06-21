package uk.org.linuxgrotto.tocrunch.api.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ExpenseLineItems {

    protected List<ExpenseLineItem> expenseLineItem;

    protected int count;

    protected BigDecimal lineItemGrossTotal;

    public List<ExpenseLineItem> getExpenseLineItem() {
        if (expenseLineItem == null) {
            expenseLineItem = new ArrayList<ExpenseLineItem>();
        }
        return this.expenseLineItem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public BigDecimal getLineItemGrossTotal() {
        return lineItemGrossTotal;
    }

    public void setLineItemGrossTotal(BigDecimal value) {
        this.lineItemGrossTotal = value;
    }

}

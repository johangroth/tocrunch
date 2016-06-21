package uk.org.linuxgrotto.tocrunch.api.model;

public class ExpenseLineItem {

    protected String expenseType;
    protected Director benefitingDirector;
    protected String lineItemDescription;
    protected Amount lineItemAmount;

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public Director getBenefitingDirector() {
        return benefitingDirector;
    }

    public void setBenefitingDirector(Director benefitingDirector) {
        this.benefitingDirector = benefitingDirector;
    }

    public String getLineItemDescription() {
        return lineItemDescription;
    }

    public void setLineItemDescription(String lineItemDescription) {
        this.lineItemDescription = lineItemDescription;
    }

    public Amount getLineItemAmount() {
        return lineItemAmount;
    }

    public void setLineItemAmount(Amount lineItemAmount) {
        this.lineItemAmount = lineItemAmount;
    }
}

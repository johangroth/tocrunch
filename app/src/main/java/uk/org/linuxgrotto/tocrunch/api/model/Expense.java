package uk.org.linuxgrotto.tocrunch.api.model;

import java.math.BigDecimal;


public class Expense {

    protected ExpenseDetails expenseDetails;
    protected ExpenseLineItems expenseLineItems;
    protected PaymentDetails paymentDetails;
    protected Receipts receipts;
    protected String note;

    protected Long expenseId;

    protected String resourceUrl;

    protected BigDecimal amount;

    public ExpenseDetails getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(ExpenseDetails expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public ExpenseLineItems getExpenseLineItems() {
        return expenseLineItems;
    }

    public void setExpenseLineItems(ExpenseLineItems expenseLineItems) {
        this.expenseLineItems = expenseLineItems;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Receipts getReceipts() {
        return receipts;
    }

    public void setReceipts(Receipts receipts) {
        this.receipts = receipts;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

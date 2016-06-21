package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.List;

public class Accounts {

    protected List<Account> bankAccounts;
    protected List<Account> creditCards;
    protected List<Account> paymentProcessingAccounts;

    protected long count;

    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<Account> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<Account> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Account> getPaymentProcessingAccounts() {
        return paymentProcessingAccounts;
    }

    public void setPaymentProcessingAccounts(List<Account> paymentProcessingAccounts) {
        this.paymentProcessingAccounts = paymentProcessingAccounts;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}

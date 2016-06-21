package uk.org.linuxgrotto.tocrunch.api.model;

public class Account {

    protected String account;
    protected Long accountId;
    protected Long lastFourDigits;
    protected String sortCode;
    protected String accountNumber;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(Long lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

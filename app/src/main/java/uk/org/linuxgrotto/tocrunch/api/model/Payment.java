package uk.org.linuxgrotto.tocrunch.api.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {

    protected Date paymentDate;
    protected BigDecimal amount;
    protected String paymentMethod;
    protected Account bankAccount;
    protected Account creditCard;
    protected Director director;
    protected Account paymentProcessingAccount;


    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Account getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Account creditCard) {
        this.creditCard = creditCard;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Account getPaymentProcessingAccount() {
        return paymentProcessingAccount;
    }

    public void setPaymentProcessingAccount(Account paymentProcessingAccount) {
        this.paymentProcessingAccount = paymentProcessingAccount;
    }
}

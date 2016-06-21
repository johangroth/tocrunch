package uk.org.linuxgrotto.tocrunch.api.model;

import java.math.BigDecimal;

public class SalesInvoiceLineItem {

    protected String lineItemDescription;
    protected BigDecimal quantity;
    protected BigDecimal rate;
    protected Amount lineItemAmount;
    protected String vatType;

    public String getLineItemDescription() {
        return lineItemDescription;
    }

    public void setLineItemDescription(String lineItemDescription) {
        this.lineItemDescription = lineItemDescription;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Amount getLineItemAmount() {
        return lineItemAmount;
    }

    public void setLineItemAmount(Amount lineItemAmount) {
        this.lineItemAmount = lineItemAmount;
    }

    public String getVatType() {
        return vatType;
    }

    public void setVatType(String vatType) {
        this.vatType = vatType;
    }
}

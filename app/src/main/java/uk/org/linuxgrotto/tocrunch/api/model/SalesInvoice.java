package uk.org.linuxgrotto.tocrunch.api.model;

import java.math.BigDecimal;

public class SalesInvoice {

    protected SalesInvoiceDetails salesInvoiceDetails;
    protected SalesInvoiceLineItems salesInvoiceLineItems;
    protected ClientPayments clientPayments;
    protected String note;
    protected File document;
    protected Long salesInvoiceId;
    protected String resourceUrl;
    protected String currency;
    protected BigDecimal allocatedAmount;


    public SalesInvoiceDetails getSalesInvoiceDetails() {
        return salesInvoiceDetails;
    }

    public void setSalesInvoiceDetails(SalesInvoiceDetails salesInvoiceDetails) {
        this.salesInvoiceDetails = salesInvoiceDetails;
    }

    public SalesInvoiceLineItems getSalesInvoiceLineItems() {
        return salesInvoiceLineItems;
    }

    public void setSalesInvoiceLineItems(SalesInvoiceLineItems salesInvoiceLineItems) {
        this.salesInvoiceLineItems = salesInvoiceLineItems;
    }

    public ClientPayments getClientPayments() {
        return clientPayments;
    }

    public void setClientPayments(ClientPayments clientPayments) {
        this.clientPayments = clientPayments;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }

    public Long getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(Long salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }
}

package uk.org.linuxgrotto.tocrunch.api.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientPayment extends Payment {

    protected Client client;
    protected Expense processingExpense;
    protected SalesInvoices salesInvoices;

    protected Long clientPaymentId;

    protected String currency;

    protected String resourceUrl;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Expense getProcessingExpense() {
        return processingExpense;
    }

    public void setProcessingExpense(Expense processingExpense) {
        this.processingExpense = processingExpense;
    }

    public SalesInvoices getSalesInvoices() {
        return salesInvoices;
    }

    public void setSalesInvoices(SalesInvoices salesInvoices) {
        this.salesInvoices = salesInvoices;
    }

    public Long getClientPaymentId() {
        return clientPaymentId;
    }

    public void setClientPaymentId(Long clientPaymentId) {
        this.clientPaymentId = clientPaymentId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}

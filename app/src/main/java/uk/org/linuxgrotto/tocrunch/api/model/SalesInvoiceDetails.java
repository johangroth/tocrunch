package uk.org.linuxgrotto.tocrunch.api.model;

import javax.xml.datatype.XMLGregorianCalendar;

public class SalesInvoiceDetails {

    protected Client client;
    protected String clientReference;
    protected XMLGregorianCalendar lastModifiedDate;
    protected XMLGregorianCalendar issuedDate;
    protected String issueDateType;
    protected XMLGregorianCalendar dueDate;
    protected XMLGregorianCalendar settledDate;
    protected String state;
    protected String invoiceNumber;
    protected Integer paymentTermsDays;
    protected Integer initialPaymentReminderDays;
    protected Integer repetitivePaymentReminderDays;
    protected Boolean emailReminderToCustomer;
    protected String purchaseOrder;
    protected String euMemberStateCountryCode;
    protected Account bankAccount;
    protected Account paymentProcessingAccount;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getClientReference() {
        return clientReference;
    }

    public void setClientReference(String clientReference) {
        this.clientReference = clientReference;
    }

    public XMLGregorianCalendar getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(XMLGregorianCalendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public XMLGregorianCalendar getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(XMLGregorianCalendar issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getIssueDateType() {
        return issueDateType;
    }

    public void setIssueDateType(String issueDateType) {
        this.issueDateType = issueDateType;
    }

    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(XMLGregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }

    public XMLGregorianCalendar getSettledDate() {
        return settledDate;
    }

    public void setSettledDate(XMLGregorianCalendar settledDate) {
        this.settledDate = settledDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getPaymentTermsDays() {
        return paymentTermsDays;
    }

    public void setPaymentTermsDays(Integer paymentTermsDays) {
        this.paymentTermsDays = paymentTermsDays;
    }

    public Integer getInitialPaymentReminderDays() {
        return initialPaymentReminderDays;
    }

    public void setInitialPaymentReminderDays(Integer initialPaymentReminderDays) {
        this.initialPaymentReminderDays = initialPaymentReminderDays;
    }

    public Integer getRepetitivePaymentReminderDays() {
        return repetitivePaymentReminderDays;
    }

    public void setRepetitivePaymentReminderDays(Integer repetitivePaymentReminderDays) {
        this.repetitivePaymentReminderDays = repetitivePaymentReminderDays;
    }

    public Boolean getEmailReminderToCustomer() {
        return emailReminderToCustomer;
    }

    public void setEmailReminderToCustomer(Boolean emailReminderToCustomer) {
        this.emailReminderToCustomer = emailReminderToCustomer;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getEuMemberStateCountryCode() {
        return euMemberStateCountryCode;
    }

    public void setEuMemberStateCountryCode(String euMemberStateCountryCode) {
        this.euMemberStateCountryCode = euMemberStateCountryCode;
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Account getPaymentProcessingAccount() {
        return paymentProcessingAccount;
    }

    public void setPaymentProcessingAccount(Account paymentProcessingAccount) {
        this.paymentProcessingAccount = paymentProcessingAccount;
    }
}

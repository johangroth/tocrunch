package uk.org.linuxgrotto.tocrunch.api.model;

public class Supplier {

    protected String name;
    protected String contactName;
    protected String email;
    protected String website;
    protected String telephone;
    protected String fax;
    protected Long supplierId;
    protected String defaultExpenseType;
    protected String resourceUrl;
    protected Boolean unknownSupplier;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getDefaultExpenseType() {
        return defaultExpenseType;
    }

    public void setDefaultExpenseType(String defaultExpenseType) {
        this.defaultExpenseType = defaultExpenseType;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Boolean getUnknownSupplier() {
        return unknownSupplier;
    }

    public void setUnknownSupplier(Boolean unknownSupplier) {
        this.unknownSupplier = unknownSupplier;
    }
}

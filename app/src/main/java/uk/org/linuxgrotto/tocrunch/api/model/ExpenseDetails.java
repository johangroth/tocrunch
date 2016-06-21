package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.Date;



public class ExpenseDetails {


    protected Supplier supplier;
    protected String supplierReference;
    protected Date postingDate;
    protected Rechargeable rechargeable;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Rechargeable getRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(Rechargeable rechargeable) {
        this.rechargeable = rechargeable;
    }
}

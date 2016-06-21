package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class SalesInvoices extends ApiQueryList {

    protected List<SalesInvoice> salesInvoice;

    public List<SalesInvoice> getSalesInvoice() {
        if (salesInvoice == null) {
            salesInvoice = new ArrayList<SalesInvoice>();
        }
        return this.salesInvoice;
    }

}

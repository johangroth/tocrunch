package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class SalesInvoiceLineItems {

    protected List<SalesInvoiceLineItem> salesInvoiceLineItem;

    protected int count;

    public List<SalesInvoiceLineItem> getSalesInvoiceLineItem() {
        if (salesInvoiceLineItem == null) {
            salesInvoiceLineItem = new ArrayList<SalesInvoiceLineItem>();
        }
        return this.salesInvoiceLineItem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

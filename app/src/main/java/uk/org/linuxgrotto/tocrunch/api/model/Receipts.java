package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class Receipts {

    protected List<File> receipt;

    protected int count;

    public List<File> getReceipt() {
        if (receipt == null) {
            receipt = new ArrayList<File>();
        }
        return this.receipt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

}

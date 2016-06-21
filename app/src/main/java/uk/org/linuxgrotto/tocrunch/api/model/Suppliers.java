package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class Suppliers extends ApiQueryList {

    protected List<Supplier> supplier;

    public List<Supplier> getSupplier() {
        if (supplier == null) {
            supplier = new ArrayList<Supplier>();
        }
        return this.supplier;
    }

}

package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.Supplier;
import uk.org.linuxgrotto.tocrunch.api.model.Suppliers;

/**
 * Created by jgroth on 04/04/16.
 */
public interface SupplierOperations {
    Suppliers getSuppliers(Integer firstResult,
                           Integer resultsPerPage);

    Supplier addSupplier(Supplier supplier);

    Supplier getSupplier(Long id);

    boolean deleteSupplier(Long id);

    Supplier updateSupplier(Long id, Supplier supplier);

}

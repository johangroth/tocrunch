package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.SupplierOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Supplier;
import uk.org.linuxgrotto.tocrunch.api.model.Suppliers;

/**
 * Created by jgroth on 04/04/16.
 */
public class SupplierTemplate implements SupplierOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public SupplierTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public Suppliers getSuppliers(Integer firstResult, Integer resultsPerPage) {
        return null;
    }

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier getSupplier(Long id) {
        return null;
    }

    @Override
    public boolean deleteSupplier(Long id) {
        return false;
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        return null;
    }
}

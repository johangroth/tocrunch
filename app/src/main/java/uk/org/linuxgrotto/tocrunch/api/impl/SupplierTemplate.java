package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import uk.org.linuxgrotto.tocrunch.api.SupplierOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Supplier;
import uk.org.linuxgrotto.tocrunch.api.model.Suppliers;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class SupplierTemplate extends CrunchOperations implements SupplierOperations {

    private static String SUPPLIERS_URL;
    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public SupplierTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        SUPPLIERS_URL = crunchOAuthUrls.getApiBaseUrl() + "/suppliers";
    }

    @Override
    public Suppliers getSuppliers(Integer firstResult, Integer resultsPerPage) {
        requireUserAuthorisation();
        URI url = URIBuilder.fromUri(SUPPLIERS_URL)
            .queryParam("firstResult", firstResult != null ? firstResult.toString() : "0")
            .queryParam("resultsPerPage", resultsPerPage != null ? resultsPerPage.toString() : "0")
            .build();
        return restTemplate.getForObject(url, Suppliers.class);
    }

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier getSupplier(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(SUPPLIERS_URL + "/" + id, Supplier.class);
    }

    @Override
    public boolean deleteSupplier(Long id) {
        requireUserAuthorisation();
        restTemplate.delete(SUPPLIERS_URL + "/" + id);
        return true;
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        requireUserAuthorisation();
        restTemplate.put(SUPPLIERS_URL + "/" + id, supplier, Supplier.class);
        return supplier;
    }
}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.SalesInvoiceOperations;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoice;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoices;

/**
 * Created by jgroth on 04/04/16.
 */
public class SalesInvoiceTemplate implements SalesInvoiceOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public SalesInvoiceTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public SalesInvoices getSalesInvoices(int firstResult, Integer resultsPerPage, String state, String clientId, String clientRef, String dueDate, String dueDateFrom, String dueDateTo) {
        return null;
    }

    @Override
    public SalesInvoice addSalesInvoice(SalesInvoice salesInvoice) {
        return null;
    }

    @Override
    public SalesInvoice getSalesInvoice(Long id) {
        return null;
    }

    @Override
    public SalesInvoice updateSalesInvoice(Long id, SalesInvoice salesInvoice) {
        return null;
    }

    @Override
    public SalesInvoice getSalesInvoiceDocument(Long id) {
        return null;
    }

    @Override
    public boolean deleteSalesInvoice(Long salesInvoiceId) {
        return false;
    }

    @Override
    public boolean issueOrEmailSalesInvoice(Long salesInvoiceId, String action) {
        return false;
    }
}

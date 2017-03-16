package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.SalesInvoiceOperations;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoice;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoices;
import uk.org.linuxgrotto.tocrunch.api.model.SalesinvoiceDocument;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class SalesInvoiceTemplate extends CrunchOperations implements SalesInvoiceOperations {

    private static String SALES_INVOICES_URL;

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public SalesInvoiceTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        SALES_INVOICES_URL = crunchOAuthUrls.getApiBaseUrl() + "/sales_invoices";
    }

    @Override
    public SalesInvoices getSalesInvoices(Integer firstResult, Integer resultsPerPage, Long clientId, String clientRef, Date dueDate,
                                          Date dueDateFrom, Date dueDateTo, String... states) {
        requireUserAuthorisation();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String invoiceStates = "";
        if (states.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (String state : states) {
                builder.append(state).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            invoiceStates = builder.toString();
        }

        URI url = URIBuilder.fromUri(SALES_INVOICES_URL)
            .queryParam("firstResult", firstResult != null ? firstResult.toString() : "")
            .queryParam("resultsPerPage", resultsPerPage != null ? resultsPerPage.toString() : "")
            .queryParam("clientId", clientId != null ? clientId.toString() : "")
            .queryParam("clientRef", clientRef)
            .queryParam("dueDate", format.format(dueDate))
            .queryParam("dueDateFrom", format.format(dueDateFrom))
            .queryParam("dueDateTo", format.format(dueDateTo))
            .queryParam("state", invoiceStates).build();

        return restTemplate.getForObject(url, SalesInvoices.class);
    }

    @Override
    public SalesInvoice addSalesInvoice(SalesInvoice salesInvoice) {
        requireUserAuthorisation();
        return restTemplate.postForObject(SALES_INVOICES_URL, salesInvoice, SalesInvoice.class);
    }

    @Override
    public SalesInvoice getSalesInvoice(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(SALES_INVOICES_URL + "/" + id, SalesInvoice.class);
    }

    @Override
    public SalesInvoice updateSalesInvoice(Long id, SalesInvoice salesInvoice) {
        requireUserAuthorisation();
        restTemplate.put(SALES_INVOICES_URL + "/" + id, salesInvoice, SalesInvoice.class);
        return salesInvoice;
    }

    @Override
    public SalesinvoiceDocument getSalesInvoiceDocument(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(SALES_INVOICES_URL + "/" + id + "/document", SalesinvoiceDocument.class);
    }

    @Override
    public boolean deleteSalesInvoice(Long salesInvoiceId) {
        requireUserAuthorisation();
        restTemplate.delete(SALES_INVOICES_URL + "/" + salesInvoiceId);
        return true;
    }

    @Override
    public boolean issueOrEmailSalesInvoice(Long salesInvoiceId, String action) {
        requireUserAuthorisation();
        restTemplate.put(SALES_INVOICES_URL + "/" + salesInvoiceId + "/" + action, SalesInvoice.class);
        return true;
    }
}

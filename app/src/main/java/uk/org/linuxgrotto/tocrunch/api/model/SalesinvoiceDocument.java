package uk.org.linuxgrotto.tocrunch.api.model;

/**
 * Created by jgroth on 06/06/16.
 */
public class SalesinvoiceDocument {

    private Long salesInvoiceId;
    private String resourceUrl;
    private Document document;

    public Long getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(Long salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

}

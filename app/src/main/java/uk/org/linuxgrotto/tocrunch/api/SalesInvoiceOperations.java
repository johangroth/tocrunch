package uk.org.linuxgrotto.tocrunch.api;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoice;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoices;
import uk.org.linuxgrotto.tocrunch.api.model.SalesinvoiceDocument;

/**
 * Created by jgroth on 04/04/16.
 */
public interface SalesInvoiceOperations {

    SalesInvoices getSalesInvoices(Integer firstResult,
                                   Integer resultsPerPage,
                                   Long clientId,
                                   String clientRef,
                                   Date dueDate,
                                   Date dueDateFrom,
                                   Date dueDateTo,
                                   String... states);

    SalesInvoice addSalesInvoice(SalesInvoice salesInvoice);

    SalesInvoice getSalesInvoice(Long id);

    SalesInvoice updateSalesInvoice(Long id, SalesInvoice salesInvoice);

    SalesinvoiceDocument getSalesInvoiceDocument(Long id);

    boolean deleteSalesInvoice(Long salesInvoiceId);

    boolean issueOrEmailSalesInvoice(Long salesInvoiceId, String action);
}

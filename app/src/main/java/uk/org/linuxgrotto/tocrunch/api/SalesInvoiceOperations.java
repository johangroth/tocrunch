package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoice;
import uk.org.linuxgrotto.tocrunch.api.model.SalesInvoices;

/**
 * Created by jgroth on 04/04/16.
 */
public interface SalesInvoiceOperations {

    SalesInvoices getSalesInvoices(int firstResult,
                                   Integer resultsPerPage,
                                   String state,
                                   String clientId,
                                   String clientRef,
                                   String dueDate,
                                   String dueDateFrom,
                                   String dueDateTo);

    SalesInvoice addSalesInvoice(SalesInvoice salesInvoice);

    SalesInvoice getSalesInvoice(Long id);

    SalesInvoice updateSalesInvoice(Long id, SalesInvoice salesInvoice);

    SalesInvoice getSalesInvoiceDocument(Long id);

    boolean deleteSalesInvoice(Long salesInvoiceId);

    boolean issueOrEmailSalesInvoice(Long salesInvoiceId, String action);
}

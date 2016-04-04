package uk.org.linuxgrotto.tocrunch.oauth;

import org.springframework.social.ApiBinding;

import uk.org.linuxgrotto.tocrunch.api.ClientOperations;
import uk.org.linuxgrotto.tocrunch.api.SalesInvoiceOperations;

/**
 * Interface specifying a basic set of operations for interacting with Crunch.
 * Implemented by CrunchTemplate.
 *
 */
public interface Crunch extends ApiBinding {

    SalesInvoiceOperations salesInvoiceOperations();

    ClientOperations clientOperations();
}

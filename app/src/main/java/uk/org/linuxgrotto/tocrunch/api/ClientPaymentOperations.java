package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.ClientPayment;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayments;

/**
 * Created by jgroth on 04/04/16.
 */
public interface ClientPaymentOperations {

    ClientPayments getClientPayments(int firstResult, int resultsPerPage);

    ClientPayment addClientPayment(ClientPayment clientPayment);

    ClientPayment getClientPayment(Long id);

    ClientPayment updateClientPayment(Long id, ClientPayment clientPayment);

}

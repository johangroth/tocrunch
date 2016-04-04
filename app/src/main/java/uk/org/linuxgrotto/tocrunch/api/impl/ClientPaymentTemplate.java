package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ClientPaymentOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayment;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayments;

/**
 * Created by jgroth on 04/04/16.
 */
public class ClientPaymentTemplate implements ClientPaymentOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public ClientPaymentTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public ClientPayments getClientPayments(int firstResult, int resultsPerPage) {
        return null;
    }

    @Override
    public ClientPayment addClientPayment(ClientPayment clientPayment) {
        return null;
    }

    @Override
    public ClientPayment getClientPayment(Long id) {
        return null;
    }

    @Override
    public ClientPayment updateClientPayment(Long id, ClientPayment clientPayment) {
        return null;
    }
}

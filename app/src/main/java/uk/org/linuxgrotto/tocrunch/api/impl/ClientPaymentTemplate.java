package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ClientPaymentOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayment;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayments;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ClientPaymentTemplate extends AbstractCrunchOperations implements ClientPaymentOperations {

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ClientPaymentTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
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

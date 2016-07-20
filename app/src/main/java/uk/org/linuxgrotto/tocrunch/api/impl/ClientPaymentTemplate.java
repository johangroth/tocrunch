package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ClientPaymentOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayment;
import uk.org.linuxgrotto.tocrunch.api.model.ClientPayments;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ClientPaymentTemplate extends AbstractCrunchOperations implements ClientPaymentOperations {

    private static String CLIENT_PAYMENTS_URL;

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ClientPaymentTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        CLIENT_PAYMENTS_URL = crunchOAuthUrls.getApiBaseUrl() + "/client_payments";
    }

    @Override
    public ClientPayments getClientPayments(int firstResult, int resultsPerPage) {
        requireUserAuthorisation();
        MultiValueMap<String, String> urlParams = new LinkedMultiValueMap<>();
        urlParams.add("firstResult", String.valueOf(firstResult));
        urlParams.add("resultsPerPage", String.valueOf(resultsPerPage));

        return restTemplate.getForObject(buildUri(CLIENT_PAYMENTS_URL, urlParams), ClientPayments.class);
    }

    @Override
    public ClientPayment addClientPayment(ClientPayment clientPayment) {
        requireUserAuthorisation();
        return restTemplate.postForObject(buildUri(CLIENT_PAYMENTS_URL), clientPayment, ClientPayment.class);
    }

    @Override
    public ClientPayment getClientPayment(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(CLIENT_PAYMENTS_URL + "/" + id.toString()), ClientPayment.class);
    }

    @Override
    public ClientPayment updateClientPayment(Long id, ClientPayment clientPayment) {
        requireUserAuthorisation();
        restTemplate.put(buildUri(CLIENT_PAYMENTS_URL + "/" + id.toString()), clientPayment);
        return clientPayment;
    }
}

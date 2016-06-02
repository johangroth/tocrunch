package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.PaymentMethodOperations;
import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethods;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class PaymentMethodTemplate extends AbstractCrunchOperations implements PaymentMethodOperations {

    private static final String PAYMENT_METHODS_IN = "/payment_methods/in";
    private static final String PAYMENT_METHODS_OUT = "/payment_methods/out";

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public PaymentMethodTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public PaymentMethods getPaymentMethodIn() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(crunchOAuthUrls.getApiBaseUrl() + PAYMENT_METHODS_IN), PaymentMethods.class);
    }

    @Override
    public PaymentMethods getPaymentMethodOut() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(crunchOAuthUrls.getApiBaseUrl() + PAYMENT_METHODS_OUT), PaymentMethods.class);
    }

}

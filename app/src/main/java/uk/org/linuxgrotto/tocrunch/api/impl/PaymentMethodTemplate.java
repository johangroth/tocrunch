package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.PaymentMethodOperations;
import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethods;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class PaymentMethodTemplate extends CrunchOperations implements PaymentMethodOperations {

    private static String PAYMENT_METHODS_IN;
    private static String PAYMENT_METHODS_OUT;

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public PaymentMethodTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        PAYMENT_METHODS_IN = crunchOAuthUrls.getApiBaseUrl() + "/payment_methods/in";
        PAYMENT_METHODS_OUT = crunchOAuthUrls.getApiBaseUrl() + "/payment_methods/out";
    }

    @Override
    public PaymentMethods getPaymentMethodIn() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(PAYMENT_METHODS_IN), PaymentMethods.class);
    }

    @Override
    public PaymentMethods getPaymentMethodOut() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(PAYMENT_METHODS_OUT), PaymentMethods.class);
    }

}

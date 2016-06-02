package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.PaymentMethodOperations;
import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethod;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class PaymentMethodTemplate extends AbstractCrunchOperations implements PaymentMethodOperations {

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public PaymentMethodTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public PaymentMethod getPaymentMethodIn() {
        return null;
    }

    @Override
    public PaymentMethod getPaymentMethodOut() {
        return null;
    }
}

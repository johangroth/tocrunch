package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.PaymentMethodOperations;
import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethod;

/**
 * Created by jgroth on 04/04/16.
 */
public class PaymentMethodTemplate implements PaymentMethodOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public PaymentMethodTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
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

package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethods;

/**
 * Created by jgroth on 04/04/16.
 */
public interface PaymentMethodOperations {
    PaymentMethods getPaymentMethodIn();

    PaymentMethods getPaymentMethodOut();
}

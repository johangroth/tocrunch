package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethod;

/**
 * Created by jgroth on 04/04/16.
 */
public interface PaymentMethodOperations {
    PaymentMethod getPaymentMethodIn();

    PaymentMethod getPaymentMethodOut();
}

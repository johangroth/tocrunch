package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;


public class PaymentMethods {

    protected List<PaymentMethod> paymentMethod;

    public List<PaymentMethod> getPaymentMethod() {
        if (paymentMethod == null) {
            paymentMethod = new ArrayList<PaymentMethod>();
        }
        return this.paymentMethod;
    }

}

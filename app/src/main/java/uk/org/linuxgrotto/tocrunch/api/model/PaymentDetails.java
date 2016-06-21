package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentDetails {

    protected List<Payment> payment;

    protected int count;

    public List<Payment> getPayment() {
        if (payment == null) {
            payment = new ArrayList<Payment>();
        }
        return this.payment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

}

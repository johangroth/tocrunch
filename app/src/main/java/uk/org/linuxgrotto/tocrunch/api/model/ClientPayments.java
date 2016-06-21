package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class ClientPayments extends ApiQueryList {

    protected List<ClientPayment> clientPayment;

    public List<ClientPayment> getClientPayment() {
        if (clientPayment == null) {
            clientPayment = new ArrayList<ClientPayment>();
        }
        return this.clientPayment;
    }

}

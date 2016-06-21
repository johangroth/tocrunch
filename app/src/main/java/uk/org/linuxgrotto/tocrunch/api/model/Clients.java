package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;


public class Clients
    extends ApiQueryList
{

    protected List<Client> client;

    public List<Client> getClient() {
        if (client == null) {
            client = new ArrayList<Client>();
        }
        return this.client;
    }

}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ClientOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Client;
import uk.org.linuxgrotto.tocrunch.api.model.Clients;

/**
 * Created by jgroth on 04/04/16.
 */
public class ClientTemplate implements ClientOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public ClientTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public Clients getClients(int firstResult, Integer resultsPerPage) {
        return null;
    }

    @Override
    public Client addClient(Client client) {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public Client updateClient(Long id, Client client) {
        return null;
    }

    @Override
    public boolean deleteClient(Long id) {
        return false;
    }
}

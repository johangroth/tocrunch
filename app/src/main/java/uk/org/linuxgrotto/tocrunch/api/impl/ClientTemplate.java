package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ClientOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Client;
import uk.org.linuxgrotto.tocrunch.api.model.Clients;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ClientTemplate extends AbstractCrunchOperations implements ClientOperations {

    private static final String TAG = ClientTemplate.class.getSimpleName();

    private static String CLIENTS_URL;

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ClientTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        CLIENTS_URL = crunchOAuthUrls.getApiBaseUrl() + "/clients";
    }

    @Override
    public Clients getClients(int firstResult, Integer resultsPerPage) {
        requireUserAuthorisation();
        MultiValueMap<String, String> urlParams = new LinkedMultiValueMap<>();
        urlParams.add("firstResult", String.valueOf(firstResult));
        urlParams.add("resultsPerPage", String.valueOf(resultsPerPage));

        return restTemplate.getForObject(buildUri(CLIENTS_URL, urlParams), Clients.class);
    }

    @Override
    public Client addClient(Client client) {
        requireUserAuthorisation();

        return restTemplate.postForObject(buildUri(CLIENTS_URL), client, Client.class);
    }

    @Override
    public Client getClient(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(CLIENTS_URL + "/" + id), Client.class);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        requireUserAuthorisation();
        restTemplate.put(buildUri(CLIENTS_URL + "/" + id), client);
        return client;
    }

    @Override
    public boolean deleteClient(Long id) {
        requireUserAuthorisation();
        restTemplate.delete(buildUri(CLIENTS_URL + "/" + id));
        return true;
    }
}

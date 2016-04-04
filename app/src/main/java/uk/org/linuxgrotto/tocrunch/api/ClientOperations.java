package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.Client;
import uk.org.linuxgrotto.tocrunch.api.model.Clients;

/**
 * Created by jgroth on 04/04/16.
 */
public interface ClientOperations {

    Clients getClients(int firstResult, Integer resultsPerPage);

    Client addClient(Client client);

    Client getClient(Long id);

    Client updateClient(Long id, Client client);

    boolean deleteClient(Long id);

}

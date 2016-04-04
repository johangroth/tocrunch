package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.CurrentUserOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Director;

/**
 * Created by jgroth on 04/04/16.
 */
public class CurrentUserTemplate implements CurrentUserOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public CurrentUserTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public Director getCurrentUser() {
        return null;
    }
}

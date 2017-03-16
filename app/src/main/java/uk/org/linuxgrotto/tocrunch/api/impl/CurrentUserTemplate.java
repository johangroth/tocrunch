package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.CurrentUserOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Director;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class CurrentUserTemplate extends CrunchOperations implements CurrentUserOperations {

    private RestTemplate restTemplate;

    private static String CURRENT_USER;

    public CurrentUserTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        CURRENT_USER = crunchOAuthUrls.getApiBaseUrl() + "/current_user";
    }

    @Override
    public Director getCurrentUser() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(CURRENT_USER), Director.class);
    }
}

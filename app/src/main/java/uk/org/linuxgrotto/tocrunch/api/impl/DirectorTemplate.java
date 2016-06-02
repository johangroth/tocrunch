package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.DirectorOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Director;
import uk.org.linuxgrotto.tocrunch.api.model.Directors;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class DirectorTemplate extends AbstractCrunchOperations implements DirectorOperations {

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public DirectorTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public Directors getDirectors() {
        return null;
    }

    @Override
    public Director getDirector(Date date) {
        return null;
    }
}

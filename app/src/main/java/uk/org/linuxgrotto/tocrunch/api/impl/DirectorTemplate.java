package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.DirectorOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Director;
import uk.org.linuxgrotto.tocrunch.api.model.Directors;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class DirectorTemplate extends AbstractCrunchOperations implements DirectorOperations {

    private static final String DIRECTORS_URL = "/directors";
    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public DirectorTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public Directors getDirectors() {
        requireUserAuthorisation();
        return restTemplate.getForObject(crunchOAuthUrls.getApiBaseUrl() + DIRECTORS_URL, Directors.class);
    }

    @Override
    public Director getDirector(Date date) {
        requireUserAuthorisation();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return restTemplate.getForObject(crunchOAuthUrls.getApiBaseUrl() + DIRECTORS_URL + "/" + format.format(date), Director.class);
    }
}

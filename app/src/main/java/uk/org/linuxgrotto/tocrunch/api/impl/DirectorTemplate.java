package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.DirectorOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Directors;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class DirectorTemplate extends CrunchOperations implements DirectorOperations {

    private static String DIRECTORS_URL;
    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public DirectorTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        DIRECTORS_URL = crunchOAuthUrls.getApiBaseUrl() + "/directors";
    }

    @Override
    public Directors getDirectors() {
        requireUserAuthorisation();
        return restTemplate.getForObject(DIRECTORS_URL, Directors.class);
    }

    @Override
    public Directors getDirector(Date date) {
        requireUserAuthorisation();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return restTemplate.getForObject(DIRECTORS_URL + "/" + format.format(date), Directors.class);
    }
}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.DirectorOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Director;
import uk.org.linuxgrotto.tocrunch.api.model.Directors;

/**
 * Created by jgroth on 04/04/16.
 */
public class DirectorTemplate implements DirectorOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public DirectorTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
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

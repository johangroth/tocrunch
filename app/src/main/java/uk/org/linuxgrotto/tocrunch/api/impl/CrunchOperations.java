package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

/**
 * Created by jgroth on 02/06/16.
 */
public class CrunchOperations {

    private final boolean isUserAuthorized;

    public CrunchOperations(boolean isUserAuthorized) {
        this.isUserAuthorized = isUserAuthorized;
    }

    protected void requireUserAuthorisation() {
        if (!isUserAuthorized) {
            throw new MissingAuthorizationException("Linux Grotto");
        }
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(path).queryParams(parameters).build();
    }

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<>();

}

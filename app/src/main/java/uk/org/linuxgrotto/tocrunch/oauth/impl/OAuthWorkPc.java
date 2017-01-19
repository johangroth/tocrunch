package uk.org.linuxgrotto.tocrunch.oauth.impl;

import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;
import uk.org.linuxgrotto.tocrunch.oauth.Globals;

/**
 * Created by jgroth on 02/06/16.
 */
public class OAuthWorkPc extends Globals implements CrunchOAuthUrls {

    private static final String CONSUMER_KEY = "to_crunch";
    private static final String SHARED_SECRET = "c376e7dc-b040-4bdf-82ed-28a32d123f41";

    private static final String OAUTH_BASE_URL = "http://10.64.10.106:8080";
    private static final String API_BASE_URL = "http://10.64.10.106:8080/rest/v2";

    @Override
    public String getApiBaseUrl() {
        return API_BASE_URL;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return OAUTH_BASE_URL + REQUEST_TOKEN;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return OAUTH_BASE_URL + ACCESS_TOKEN;
    }

    @Override
    public String getAuthorisationEndpoint() {
        return OAUTH_BASE_URL + AUTHORIZE;
    }

    @Override
    public String getConsumerKey() {
        return CONSUMER_KEY;
    }

    @Override
    public String getSharedSecret() {
        return SHARED_SECRET;
    }

    @Override
    public String getCallbackUrl() {
        return CALLBACK_URL;
    }
}

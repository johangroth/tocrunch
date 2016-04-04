package uk.org.linuxgrotto.tocrunch.oauth;

/**
 * Created by jgroth on 22/03/16.
 */
public abstract class CrunchCommonApiV2 {

    protected static final String REQUEST_TOKEN = "/crunch-core/oauth/request_token";
    protected static final String AUTHORIZE = "/crunch-core/login/oauth-login.seam";
    protected static final String ACCESS_TOKEN = "/crunch-core/oauth/access_token";

    protected abstract String getApiBaseUrl();

}

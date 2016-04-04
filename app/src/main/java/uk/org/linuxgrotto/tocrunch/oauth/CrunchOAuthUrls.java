package uk.org.linuxgrotto.tocrunch.oauth;

/**
 * Created by jgroth on 04/04/16.
 */
public interface CrunchOAuthUrls {

    String getApiBaseUrl();

    String getRequestTokenEndpoint();

    String getAccessTokenEndpoint();

    String getAuthorisationEndpoint();

    String getConsumerKey();

    String getSharedSecret();

    String getCallbackUrl();
}

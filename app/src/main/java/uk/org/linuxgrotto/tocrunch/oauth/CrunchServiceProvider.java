package uk.org.linuxgrotto.tocrunch.oauth;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchServiceProvider extends AbstractOAuth1ServiceProvider<Crunch> {

    public CrunchServiceProvider(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
                OAuthSandbox.getRequestTokenEndpoint(),
                OAuthSandbox.getAuthorizationEndpoint(),
                OAuthSandbox.getAccessTokenEndpoint()));
    }

    public Crunch getApi(String accessToken, String secret) {
        return new CrunchTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
    }
}

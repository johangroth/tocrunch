package uk.org.linuxgrotto.tocrunch.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.impl.CrunchTemplate;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchServiceProvider extends AbstractOAuth1ServiceProvider<Crunch> {

    public CrunchServiceProvider(String consumerKey, String consumerSecret, CrunchOAuthUrls apiV2) {
        super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
                apiV2.getRequestTokenEndpoint(),
                apiV2.getAuthorisationEndpoint(),
                apiV2.getAccessTokenEndpoint()));
    }

    public Crunch getApi(String accessToken, String secret) {
        return new CrunchTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
    }
}

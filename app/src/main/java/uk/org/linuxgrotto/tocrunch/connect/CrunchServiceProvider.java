package uk.org.linuxgrotto.tocrunch.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.impl.CrunchTemplate;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchServiceProvider extends AbstractOAuth1ServiceProvider<Crunch> {

    private CrunchOAuthUrls crunchOAuthUrls;

    public CrunchServiceProvider(String consumerKey, String consumerSecret, CrunchOAuthUrls crunchOAuthUrls) {
        super(consumerKey, consumerSecret, new ToCrunchOAuth1Template(consumerKey, consumerSecret,
                crunchOAuthUrls.getRequestTokenEndpoint(),
                crunchOAuthUrls.getAuthorisationEndpoint(),
                crunchOAuthUrls.getAccessTokenEndpoint()));
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    public Crunch getApi(String accessToken, String secret) {
        return new CrunchTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret, crunchOAuthUrls);
    }
}

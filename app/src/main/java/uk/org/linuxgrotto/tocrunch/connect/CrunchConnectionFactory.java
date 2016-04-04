package uk.org.linuxgrotto.tocrunch.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchConnectionFactory extends OAuth1ConnectionFactory<Crunch>  {

    public CrunchConnectionFactory(String consumerKey, String consumerSecret, CrunchOAuthUrls crunchOAuthUrls) {
        super("crunch", new CrunchServiceProvider(consumerKey, consumerSecret, crunchOAuthUrls), new CrunchAdapter());
    }

}

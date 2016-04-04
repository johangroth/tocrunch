package uk.org.linuxgrotto.tocrunch.oauth;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchConnectionFactory extends OAuth1ConnectionFactory<Crunch>  {
    public CrunchConnectionFactory(String consumerKey, String consumerSecret) {
        super("crunch", new CrunchServiceProvider(consumerKey, consumerSecret), new CrunchAdapter());
    }

}

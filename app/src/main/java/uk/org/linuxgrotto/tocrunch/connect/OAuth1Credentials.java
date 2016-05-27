package uk.org.linuxgrotto.tocrunch.connect;

/**
 * Created by jgroth on 26/05/16.
 */
class OAuth1Credentials {
    private final String consumerKey;

    private final String consumerSecret;

    private final String accessToken;

    private final String accessTokenSecret;

    public OAuth1Credentials(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}

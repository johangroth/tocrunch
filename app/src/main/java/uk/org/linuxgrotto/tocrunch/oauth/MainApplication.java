package uk.org.linuxgrotto.tocrunch.oauth;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import org.springframework.security.crypto.encrypt.AndroidEncryptors;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.sqlite.SQLiteConnectionRepository;
import org.springframework.social.connect.sqlite.support.SQLiteConnectionRepositoryHelper;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.connect.CrunchConnectionFactory;
import uk.org.linuxgrotto.tocrunch.oauth.impl.OAuthSandbox;

/**
 * Created by jgroth on 04/04/16.
 */
public class MainApplication extends Application {

    private ConnectionFactoryRegistry connectionFactoryRegistry;

    private SQLiteOpenHelper repositoryHelper;

    private ConnectionRepository connectionRepository;

    private CrunchOAuthUrls oAuthUrls = new OAuthSandbox();

    public static Crunch crunch;

    // ***************************************
    // Application Methods
    // ***************************************
    @Override
    public void onCreate() {
        super.onCreate();
        // create a new ConnectionFactoryLocator and populate it with a Crunch ConnectionFactory
        connectionFactoryRegistry = new ConnectionFactoryRegistry();
        connectionFactoryRegistry.addConnectionFactory(new CrunchConnectionFactory(getCrunchConsumerToken(),
                getCrunchConsumerTokenSecret(), oAuthUrls));

        // set up the database and encryption
        repositoryHelper = new SQLiteConnectionRepositoryHelper(this);
        connectionRepository = new SQLiteConnectionRepository(repositoryHelper,
                connectionFactoryRegistry, AndroidEncryptors.text("password", "5c0744940b5c369b"));

        crunch = connectionRepository.findPrimaryConnection(Crunch.class).getApi();
    }

    // ***************************************
    // Public methods
    // ***************************************
    public ConnectionRepository getConnectionRepository() {
        return connectionRepository;
    }

    public CrunchConnectionFactory getCrunchConnectionFactory() {
        return (CrunchConnectionFactory) connectionFactoryRegistry.getConnectionFactory(Crunch.class);
    }

    public CrunchOAuthUrls getCrunchOAuthUrls() {
        return oAuthUrls;
    }

    // ***************************************
    // Private methods
    // ***************************************
    private String getCrunchConsumerToken() {
        return oAuthUrls.getConsumerKey();
    }

    private String getCrunchConsumerTokenSecret() {
        return oAuthUrls.getSharedSecret();
    }


}

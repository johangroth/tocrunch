package uk.org.linuxgrotto.tocrunch.oauth;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import org.springframework.security.crypto.encrypt.AndroidEncryptors;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.sqlite.SQLiteConnectionRepository;
import org.springframework.social.connect.sqlite.support.SQLiteConnectionRepositoryHelper;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;

/**
 * Created by jgroth on 04/04/16.
 */
public class MainApplication extends Application {
    private ConnectionFactoryRegistry connectionFactoryRegistry;
    private SQLiteOpenHelper repositoryHelper;
    private ConnectionRepository connectionRepository;

    // ***************************************
    // Application Methods
    // ***************************************
    @Override
    public void onCreate() {
        super.onCreate();
        // create a new ConnectionFactoryLocator and populate it with a Crunch ConnectionFactory
        this.connectionFactoryRegistry = new ConnectionFactoryRegistry();
        this.connectionFactoryRegistry.addConnectionFactory(new CrunchConnectionFactory(getCrunchConsumerToken(),
                getCrunchConsumerTokenSecret()));

        // set up the database and encryption
        this.repositoryHelper = new SQLiteConnectionRepositoryHelper(this);
        this.connectionRepository = new SQLiteConnectionRepository(this.repositoryHelper,
                this.connectionFactoryRegistry, AndroidEncryptors.text("password", "5c0744940b5c369b"));
    }

    // ***************************************
    // Private methods
    // ***************************************
    private String getCrunchConsumerToken() {
        return OAuthSandbox.CONSUMER_KEY;
    }

    private String getCrunchConsumerTokenSecret() {
        return OAuthSandbox.SHARED_SECRET;
    }

    // ***************************************
    // Public methods
    // ***************************************
    public ConnectionRepository getConnectionRepository() {
        return this.connectionRepository;
    }

    public CrunchConnectionFactory getCrunchConnectionFactory() {
        return (CrunchConnectionFactory) this.connectionFactoryRegistry.getConnectionFactory(Crunch.class);
    }

}

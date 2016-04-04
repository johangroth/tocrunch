package uk.org.linuxgrotto.tocrunch.oauth;

import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

import uk.org.linuxgrotto.tocrunch.api.ClientOperations;
import uk.org.linuxgrotto.tocrunch.api.impl.ClientTemplate;
import uk.org.linuxgrotto.tocrunch.api.SalesInvoiceOperations;
import uk.org.linuxgrotto.tocrunch.api.impl.SalesInvoiceTemplate;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchTemplate extends AbstractOAuth1ApiBinding implements Crunch {

    private SalesInvoiceOperations salesInvoiceOperations;
    private ClientOperations clientOperations;

    public CrunchTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        init();
    }

    @Override
    public SalesInvoiceOperations salesInvoiceOperations() {
        return salesInvoiceOperations;
    }

    @Override
    public ClientOperations clientOperations() {
        return clientOperations;
    }

    private void init() {
        this.salesInvoiceOperations = new SalesInvoiceTemplate(getRestTemplate(), isAuthorized());
        this.clientOperations = new ClientTemplate(getRestTemplate(), isAuthorized());
    }
}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ExpenseTypeOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseTypes;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ExpenseTypeTemplate extends AbstractCrunchOperations implements ExpenseTypeOperations {

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ExpenseTypeTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public ExpenseTypes getExpenseTypes() {
        return null;
    }
}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ExpenseTypeOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseTypes;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ExpenseTypesTemplate extends AbstractCrunchOperations implements ExpenseTypeOperations {

    private static String EXPENSE_TYPES_URL;

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ExpenseTypesTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        EXPENSE_TYPES_URL = crunchOAuthUrls.getApiBaseUrl() + "/expense_types";
    }

    @Override
    public ExpenseTypes getExpenseTypes() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(EXPENSE_TYPES_URL), ExpenseTypes.class);
    }
}

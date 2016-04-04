package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.ExpenseTypeOperations;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseTypes;

/**
 * Created by jgroth on 04/04/16.
 */
public class ExpenseTypeTemplate implements ExpenseTypeOperations {

    private boolean authorised;
    private RestTemplate restTemplate;

    public ExpenseTypeTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public ExpenseTypes getExpenseTypes() {
        return null;
    }
}

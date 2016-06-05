package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.ExpenseOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Expense;
import uk.org.linuxgrotto.tocrunch.api.model.Expenses;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ExpenseTemplate extends AbstractCrunchOperations implements ExpenseOperations {

    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ExpenseTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public Expenses getExpenses(Integer firstResult, Integer resultsPerPage, Long supplierId, Date date, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return null;
    }

    @Override
    public Expense getExpense(Long id) {
        return null;
    }

    @Override
    public boolean deleteExpense(Long id) {
        return false;
    }
}

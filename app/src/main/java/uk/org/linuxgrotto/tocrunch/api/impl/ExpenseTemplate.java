package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.ExpenseOperations;
import uk.org.linuxgrotto.tocrunch.api.model.Expense;
import uk.org.linuxgrotto.tocrunch.api.model.Expenses;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class ExpenseTemplate extends AbstractCrunchOperations implements ExpenseOperations {
    private static final String EXPENSES_URL = "/expenses";
    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ExpenseTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
    }

    @Override
    public Expenses getExpenses(Integer firstResult, Integer resultsPerPage, Long supplierId, Date date, Date dateFrom, Date dateTo) {
        requireUserAuthorisation();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        URI url = URIBuilder.fromUri(crunchOAuthUrls.getApiBaseUrl() + EXPENSES_URL)
            .queryParam("firstResult", firstResult.toString())
            .queryParam("resultsPerPage", resultsPerPage.toString())
            .queryParam("supplierId", supplierId.toString())
            .queryParam("date", format.format(date))
            .queryParam("dateFrom", format.format(dateFrom))
            .queryParam("dateTo", format.format(dateTo)).build();
        return restTemplate.getForObject(url, Expenses.class);
    }

    @Override
    public Expense addExpense(Expense expense) {
        requireUserAuthorisation();
        return restTemplate.postForObject(buildUri(crunchOAuthUrls.getApiBaseUrl() + EXPENSES_URL), expense, Expense.class);
    }

    @Override
    public Expense getExpense(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(crunchOAuthUrls.getApiBaseUrl() + EXPENSES_URL + "/" + id), Expense.class);
    }

    @Override
    public boolean deleteExpense(Long id) {
        requireUserAuthorisation();
        restTemplate.delete(buildUri(crunchOAuthUrls.getApiBaseUrl() + EXPENSES_URL + "/" + id));
        return true;
    }
}

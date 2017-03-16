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
public class ExpenseTemplate extends CrunchOperations implements ExpenseOperations {
    private static String EXPENSES_URL;
    private RestTemplate restTemplate;

    private CrunchOAuthUrls crunchOAuthUrls;

    public ExpenseTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        this.crunchOAuthUrls = crunchOAuthUrls;
        EXPENSES_URL = crunchOAuthUrls.getApiBaseUrl() + "/expenses";
    }

    @Override
    public Expenses getExpenses(Integer firstResult, Integer resultsPerPage, Long supplierId, Date date, Date dateFrom, Date dateTo) {
        requireUserAuthorisation();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        URI url = URIBuilder.fromUri(EXPENSES_URL)
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
        return restTemplate.postForObject(buildUri(EXPENSES_URL), expense, Expense.class);
    }

    @Override
    public Expense getExpense(Long id) {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(EXPENSES_URL + "/" + id), Expense.class);
    }

    @Override
    public boolean deleteExpense(Long id) {
        requireUserAuthorisation();
        restTemplate.delete(buildUri(EXPENSES_URL + "/" + id));
        return true;
    }
}

package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import uk.org.linuxgrotto.tocrunch.api.AccountOperations;
import uk.org.linuxgrotto.tocrunch.api.AccountType;
import uk.org.linuxgrotto.tocrunch.api.model.Account;
import uk.org.linuxgrotto.tocrunch.api.model.Accounts;
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/**
 * Created by jgroth on 04/04/16.
 */
public class AccountTemplate extends CrunchOperations implements AccountOperations {

    private static String ACCOUNTS_URL;

    private RestTemplate restTemplate;

    public AccountTemplate(RestTemplate restTemplate, boolean authorised, CrunchOAuthUrls crunchOAuthUrls) {
        super(authorised);
        this.restTemplate = restTemplate;
        ACCOUNTS_URL = crunchOAuthUrls.getApiBaseUrl() + "/accounts";
    }

    @Override
    public Accounts getAccounts() {
        requireUserAuthorisation();
        return restTemplate.getForObject(buildUri(ACCOUNTS_URL), Accounts.class);
    }

    @Override
    public List<Account> getAccount(AccountType accountType) {
        requireUserAuthorisation();
        Accounts accounts =  restTemplate.getForObject(ACCOUNTS_URL + "/" + accountType.name().toLowerCase(), Accounts.class);
        switch (accountType) {
            case BANK_ACCOUNT:
                return accounts.getBankAccounts();
            case CREDIT_CARD:
                return accounts.getCreditCards();
            case PAYMENT_PROCESSING_ACCOUNT:
                return accounts.getPaymentProcessingAccounts();
        }
        return null;
    }
}

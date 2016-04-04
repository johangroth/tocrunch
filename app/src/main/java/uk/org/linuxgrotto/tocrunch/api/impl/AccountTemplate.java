package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.web.client.RestTemplate;

import uk.org.linuxgrotto.tocrunch.api.AccountOperations;
import uk.org.linuxgrotto.tocrunch.api.AccountType;
import uk.org.linuxgrotto.tocrunch.api.model.Account;
import uk.org.linuxgrotto.tocrunch.api.model.Accounts;

/**
 * Created by jgroth on 04/04/16.
 */
public class AccountTemplate implements AccountOperations {


    private boolean authorised;
    private RestTemplate restTemplate;

    public AccountTemplate(RestTemplate restTemplate, boolean authorised) {
        this.restTemplate = restTemplate;
        this.authorised = authorised;
    }

    @Override
    public Accounts getAccounts() {
        return null;
    }

    @Override
    public Account getAccount(AccountType accountType) {
        return null;
    }
}

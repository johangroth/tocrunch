package uk.org.linuxgrotto.tocrunch.api;

import uk.org.linuxgrotto.tocrunch.api.model.Account;
import uk.org.linuxgrotto.tocrunch.api.model.Accounts;

/**
 * Created by jgroth on 04/04/16.
 */
public interface AccountOperations {
    Accounts getAccounts();

    Account getAccount(AccountType accountType);
}

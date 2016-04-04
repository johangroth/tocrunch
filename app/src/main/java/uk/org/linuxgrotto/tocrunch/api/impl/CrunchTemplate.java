package uk.org.linuxgrotto.tocrunch.api.impl;

import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

import uk.org.linuxgrotto.tocrunch.api.AccountOperations;
import uk.org.linuxgrotto.tocrunch.api.ClientOperations;
import uk.org.linuxgrotto.tocrunch.api.ClientPaymentOperations;
import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.CurrentUserOperations;
import uk.org.linuxgrotto.tocrunch.api.DirectorOperations;
import uk.org.linuxgrotto.tocrunch.api.ExpenseOperations;
import uk.org.linuxgrotto.tocrunch.api.ExpenseTypeOperations;
import uk.org.linuxgrotto.tocrunch.api.PaymentMethodOperations;
import uk.org.linuxgrotto.tocrunch.api.SalesInvoiceOperations;
import uk.org.linuxgrotto.tocrunch.api.SupplierOperations;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchTemplate extends AbstractOAuth1ApiBinding implements Crunch {


    private AccountOperations accountOperations;

    private ClientOperations clientOperations;

    private ClientPaymentOperations clientPaymentOperations;

    private CurrentUserOperations currentUserOperations;

    private DirectorOperations directorOperations;

    private ExpenseOperations expenseOperations;

    private ExpenseTypeOperations expenseTypeOperations;

    private PaymentMethodOperations paymentMethodOperations;

    private SalesInvoiceOperations salesInvoiceOperations;

    private SupplierOperations supplierOperations;

    public CrunchTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        init();
    }

    @Override
    public AccountOperations accountOperations() {
        return accountOperations;
    }

    @Override
    public ClientOperations clientOperations() {
        return clientOperations;
    }

    @Override
    public ClientPaymentOperations clientPaymentOperations() {
        return clientPaymentOperations;
    }

    @Override
    public CurrentUserOperations currentUserOperations() {
        return currentUserOperations;
    }

    @Override
    public DirectorOperations directorOperations() {
        return directorOperations;
    }

    @Override
    public ExpenseOperations expenseOperations() {
        return expenseOperations;
    }

    @Override
    public ExpenseTypeOperations expenseTypeOperations() {
        return expenseTypeOperations;
    }

    @Override
    public PaymentMethodOperations paymentMethodOperations() {
        return paymentMethodOperations;
    }

    @Override
    public SalesInvoiceOperations salesInvoiceOperations() {
        return salesInvoiceOperations;
    }

    @Override
    public SupplierOperations supplierOperations() {
        return supplierOperations;
    }

    private void init() {
        accountOperations = new AccountTemplate(getRestTemplate(), isAuthorized());

        clientOperations = new ClientTemplate(getRestTemplate(), isAuthorized());

        clientPaymentOperations = new ClientPaymentTemplate(getRestTemplate(), isAuthorized());

        currentUserOperations = new CurrentUserTemplate(getRestTemplate(), isAuthorized());

        directorOperations = new DirectorTemplate(getRestTemplate(), isAuthorized());

        expenseOperations = new ExpenseTemplate(getRestTemplate(), isAuthorized());

        expenseTypeOperations = new ExpenseTypeTemplate(getRestTemplate(), isAuthorized());

        paymentMethodOperations = new PaymentMethodTemplate(getRestTemplate(), isAuthorized());

        salesInvoiceOperations = new SalesInvoiceTemplate(getRestTemplate(), isAuthorized());

        supplierOperations = new SupplierTemplate(getRestTemplate(), isAuthorized());
    }
}

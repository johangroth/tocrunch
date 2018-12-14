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
import uk.org.linuxgrotto.tocrunch.oauth.CrunchOAuthUrls;

/*
 * tocrunch
 * Copyright 2017 Johan Groth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    private CrunchOAuthUrls crunchOAuthUrls;

    public CrunchTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, CrunchOAuthUrls crunchOAuthUrls) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        this.crunchOAuthUrls = crunchOAuthUrls;
//        init();
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

    @Override
    protected void postConstructionConfiguration() {
//        super.postConstructionConfiguration();
        init();
    }

    private void init() {
        accountOperations = new AccountTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        clientOperations = new ClientTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        clientPaymentOperations = new ClientPaymentTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        currentUserOperations = new CurrentUserTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        directorOperations = new DirectorTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        expenseOperations = new ExpenseTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        expenseTypeOperations = new ExpenseTypesTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        paymentMethodOperations = new PaymentMethodTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        salesInvoiceOperations = new SalesInvoiceTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);

        supplierOperations = new SupplierTemplate(getRestTemplate(), isAuthorized(), crunchOAuthUrls);
    }
}

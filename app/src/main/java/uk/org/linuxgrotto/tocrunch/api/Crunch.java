package uk.org.linuxgrotto.tocrunch.api;

import org.springframework.social.ApiBinding;

/**
 * Interface specifying a basic set of operations for interacting with Crunch.
 * Implemented by CrunchTemplate.
 *
 */
public interface Crunch extends ApiBinding {

    AccountOperations accountOperations();

    ClientOperations clientOperations();

    ClientPaymentOperations clientPaymentOperations();

    CurrentUserOperations currentUserOperations();

    DirectorOperations directorOperations();

    ExpenseOperations expenseOperations();

    ExpenseTypeOperations expenseTypeOperations();

    PaymentMethodOperations paymentMethodOperations();

    SalesInvoiceOperations salesInvoiceOperations();

    SupplierOperations supplierOperations();
}

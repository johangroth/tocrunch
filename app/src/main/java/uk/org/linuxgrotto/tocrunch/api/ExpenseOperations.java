package uk.org.linuxgrotto.tocrunch.api;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.model.Expense;
import uk.org.linuxgrotto.tocrunch.api.model.Expenses;

/**
 * Created by jgroth on 04/04/16.
 */
public interface ExpenseOperations {
    Expenses getExpenses(Integer firstResult,
                         Integer resultsPerPage,
                         Long supplierId,
                         Date date,
                         Date dateFrom,
                         Date dateTo);

    Expense addExpense(Expense expense);

    Expense getExpense(Long id);

    boolean deleteExpense(Long id);
}

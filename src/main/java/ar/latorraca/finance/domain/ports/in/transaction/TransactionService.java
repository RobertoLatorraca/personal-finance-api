package ar.latorraca.finance.domain.ports.in.transaction;

import ar.latorraca.finance.domain.models.transaction.Transaction;

public interface TransactionService {

	Transaction save(Transaction transaction);

}

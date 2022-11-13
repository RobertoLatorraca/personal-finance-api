package ar.latorraca.finance.domain.ports.out.transaction;

import ar.latorraca.finance.domain.models.transaction.Transaction;

public interface TransactionPersistence {

	Transaction save(Transaction transaction);

}

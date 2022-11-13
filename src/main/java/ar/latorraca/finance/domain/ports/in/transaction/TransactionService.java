package ar.latorraca.finance.domain.ports.in.transaction;

import java.util.List;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.transaction.Transaction;

public interface TransactionService {

	Transaction save(Transaction transaction);

	List<Transaction> findByAccount(Account account);

}

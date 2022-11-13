package ar.latorraca.finance.domain.services.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.transaction.Transaction;
import ar.latorraca.finance.domain.ports.in.transaction.TransactionService;
import ar.latorraca.finance.domain.ports.out.transaction.TransactionPersistence;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionPersistence transactionPersistence;

	@Override
	public Transaction save(Transaction transaction) {
		return transaction;
		//return transactionPersistence.save(transaction);
	}

	@Override
	public List<Transaction> findByAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}

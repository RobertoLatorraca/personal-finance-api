package ar.latorraca.finance.domain.services.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.transaction.Transaction;
import ar.latorraca.finance.domain.models.transaction.TransactionType;
import ar.latorraca.finance.domain.ports.in.transaction.TransactionService;
import ar.latorraca.finance.domain.ports.out.transaction.TransactionPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionPersistence transactionPersistence;

	@Override
	public Transaction save(Transaction transaction) {
		checkDetailAmountSum(transaction);
		if (transaction.getTransactionType() == TransactionType.TRANSFER) return saveTransferTransaction(transaction);
		return saveIncomeExpenseTransaction(transaction);
	}

	@Override
	public List<Transaction> findByAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	private Transaction saveTransferTransaction(Transaction transaction) {
		return transaction;
	}

	private Transaction saveIncomeExpenseTransaction(Transaction transaction) {
		checkTransactionType(transaction);
		Transaction result = transactionPersistence.save(transaction);
		updateAccountBalance(transaction);
		return result;
	}

	private void checkDetailAmountSum(Transaction transaction) {
		Double sum = transaction.getTransactionDetail()
				.stream()
				.reduce(0D, (s, element) -> s + element.getAmount(), Double::sum);
		if (Double.compare(sum, transaction.getTotalAmount()) != 0)
				throw new BadRequestException("The sum of the amount of the details does not match the total of the operation.");
	}

	private void checkTransactionType(Transaction transaction) {
		if (transaction.getTransactionType() == TransactionType.INCOME && transaction.getTotalAmount() < 0)
			throw new BadRequestException("The transaction type is wrong.");
		if (transaction.getTransactionType() == TransactionType.EXPENSE && transaction.getTotalAmount() > 0)
			throw new BadRequestException("The transaction type is wrong.");
	}

	private void updateAccountBalance(Transaction transaction) {
		
	}

}

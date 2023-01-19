package ar.latorraca.finance.adapters.secondary.jpa.persistences.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TransactionEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction.TransactionRepository;
import ar.latorraca.finance.domain.models.transaction.Transaction;
import ar.latorraca.finance.domain.ports.out.transaction.TransactionPersistence;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@Service
public class TransactionPersistenceImpl implements TransactionPersistence {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction save(Transaction transaction) {


		


		TransactionEntity transactionEntity = transactionRepository.save(
				ModelMapperFacade.map(transaction, TransactionEntity.class));
		System.out.println(transactionEntity.getAccount().toString());
		return ModelMapperFacade.mapEntityToTransaction(transactionEntity);
		/*
		return ModelMapperFacade.map(
				transactionRepository.save(ModelMapperFacade.map(transaction, TransactionEntity.class)),
				Transaction.class);*/
	}

}

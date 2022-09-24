package ar.latorraca.finance.adapters.secondary.jpa.persistences.account;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.AccountEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.account.BalanceEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.account.AccountRepository;
import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.AccountType;
import ar.latorraca.finance.domain.models.account.Balance;
import ar.latorraca.finance.domain.ports.out.account.AccountPersistence;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@Service
public class AccountPersistenceImpl implements AccountPersistence {

	@Autowired
	private AccountRepository accountRepository;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Account> T save(T account) {
		Account accountDb = ModelMapperFacade.map(
				accountRepository.save(
						ModelMapperFacade.map(account, AccountEntity.class)),
				account.getAccountType().getClazz());
		return (T) ModelMapperFacade.map(accountDb, account.getAccountType().getClazz());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Account> findAll() {
		List<? extends Account> accountDbList = accountRepository.findAll().stream()
				.map(a -> {
					AccountType accountType = AccountType.valueOf(a.getAccountType());
					Set<BalanceEntity> balanceDb = a.getBalance();
					a.setBalance(null);
					var account = ModelMapperFacade.map(a, accountType.getClazz());
					account.setBalance(ModelMapperFacade.mapSet(balanceDb, Balance.class));
					return account;
					//return ModelMapperFacade.map(a, accountType.getClazz());
				})
				.toList();
		return accountDbList;
	}

}

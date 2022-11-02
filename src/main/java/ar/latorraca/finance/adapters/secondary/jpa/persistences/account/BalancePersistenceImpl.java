package ar.latorraca.finance.adapters.secondary.jpa.persistences.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.AccountEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.account.BalanceEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.account.BalanceRepository;
import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Balance;
import ar.latorraca.finance.domain.ports.out.account.BalancePersistence;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@Service
public class BalancePersistenceImpl implements BalancePersistence {

	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public <T extends Account> Balance save(T account, Balance balance) {
		BalanceEntity balanceEntity = ModelMapperFacade.map(balance, BalanceEntity.class);
		balanceEntity.setAccount(ModelMapperFacade.map(account, AccountEntity.class));
		return ModelMapperFacade.map(balanceRepository.save(balanceEntity), Balance.class);
	}

}

package ar.latorraca.finance.domain.services.account;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.ports.in.account.AccountService;
import ar.latorraca.finance.domain.ports.in.account.BalanceService;
import ar.latorraca.finance.domain.ports.out.account.AccountPersistence;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountPersistence accountPersistence;
	
	@Autowired
	private BalanceService balanceService;

	@Override
	public <T extends Account> T save(T account) {
		T result = accountPersistence.save(account);
		if (account.getBalance() == null) {
			result.setBalance(
					Set.of(balanceService.save(
							result, balanceService.createBalance(account.getCurrency()))
			));
		}
		return result;
	}

	@Override
	public <T extends Account> List<T> findAll() {
		return accountPersistence.findAll();
	}

}

package ar.latorraca.finance.domain.services.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.ports.in.account.AccountService;
import ar.latorraca.finance.domain.ports.out.account.AccountPersistence;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountPersistence accountPersistence;

	@Override
	public <T extends Account> T save(T account) {
		return accountPersistence.save(account);
	}

	@Override
	public <T extends Account> List<T> findAll() {
		return accountPersistence.findAll();
	}

}

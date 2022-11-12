package ar.latorraca.finance.domain.services.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.ports.in.account.AccountService;
import ar.latorraca.finance.domain.ports.in.account.BalanceService;
import ar.latorraca.finance.domain.ports.out.account.AccountPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountPersistence accountPersistence;
	
	@Autowired
	private BalanceService balanceService;

	@Override
	public <T extends Account> T create(T account) {
		if (account.getId() != null) throw new BadRequestException("Account id must be null.");
		T result = accountPersistence.save(account);
		result.addBalance(balanceService.save(
				result, balanceService.createBalance(account.getCurrency())));
		return result;
	}

	@Override
	public <T extends Account> List<T> findAll() {
		return accountPersistence.findAll();
	}

}

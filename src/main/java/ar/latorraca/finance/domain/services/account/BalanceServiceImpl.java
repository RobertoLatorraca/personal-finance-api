package ar.latorraca.finance.domain.services.account;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Balance;
import ar.latorraca.finance.domain.models.account.Currency;
import ar.latorraca.finance.domain.ports.in.account.BalanceService;
import ar.latorraca.finance.domain.ports.out.account.BalancePersistence;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private BalancePersistence balancePersistence;

	@Override
	public Balance createBalance(Currency currency) {
		return Balance.builder()
				.balance(0.0)
				.currency(currency)
				.balanceAt(Date.from(Instant.now()))
				.build();
	}

	@Override
	public <T extends Account> Balance save(T account, Balance balance) {
		return balancePersistence.save(account, balance);
	}

}

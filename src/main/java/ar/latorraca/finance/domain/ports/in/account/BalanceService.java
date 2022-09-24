package ar.latorraca.finance.domain.ports.in.account;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Balance;
import ar.latorraca.finance.domain.models.account.Currency;

public interface BalanceService {

	Balance createBalance(Currency currency);

	<T extends Account> Balance save(T account, Balance balance);

}

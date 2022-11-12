package ar.latorraca.finance.domain.ports.out.account;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Balance;

public interface BalancePersistence {

	<T extends Account> Balance save(T account, Balance balance);

}

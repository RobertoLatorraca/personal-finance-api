package ar.latorraca.finance.domain.ports.in.account;

import java.util.List;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.AccountType;

public interface AccountService {

	<T extends Account> T create(T account);

	<T extends Account> List<T> findAll();

	List<AccountType> getAccountTypes();

}

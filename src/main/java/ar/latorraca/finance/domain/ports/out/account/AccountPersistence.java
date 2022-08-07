package ar.latorraca.finance.domain.ports.out.account;

import java.util.List;

import ar.latorraca.finance.domain.models.account.Account;

public interface AccountPersistence {

	<T extends Account> T save(T account);

	<T extends Account> List<T> findAll();

}

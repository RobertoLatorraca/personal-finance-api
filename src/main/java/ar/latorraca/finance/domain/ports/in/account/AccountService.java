package ar.latorraca.finance.domain.ports.in.account;

import java.util.List;

import ar.latorraca.finance.domain.models.account.Account;

public interface AccountService {

	<T extends Account> T save(T account);

	<T extends Account> List<T> findAll();

}

package ar.latorraca.finance.domain.models.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {

	private String id;
	private String account;
	private Currency currency;
	private AccountType accountType;
	private boolean enabled;

	public abstract void addBalance(Balance balance);

}

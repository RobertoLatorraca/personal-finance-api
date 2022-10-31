package ar.latorraca.finance.domain.models.account;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {

	private UUID id;
	private String account;
	private Currency currency;
	private AccountType accountType;
	private boolean enabled;

	public abstract void addBalance(Balance balance);

}

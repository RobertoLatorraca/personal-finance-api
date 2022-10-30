package ar.latorraca.finance.domain.models.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount extends Account {

	private Balance balance;
	private Bank bank;
	private String accountNumber;
	private String cbu;
	private String alias;

	@Override
	public void addBalance(Balance balance) {
		setBalance(balance);
	}

}

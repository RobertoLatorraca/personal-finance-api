package ar.latorraca.finance.domain.models.account;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CashAccount extends Account {

	private Set<Balance> balance = new HashSet<>();

	@Override
	public void addBalance(Balance balance) {
		getBalance().add(balance);
	}

}

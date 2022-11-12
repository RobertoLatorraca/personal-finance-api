package ar.latorraca.finance.domain.models.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditCardAccount extends Account {

	private Set<Balance> balance = new HashSet<>();
	private CreditCardBrand creditCardBrand;
	private String creditCardNumber;
	private Date expiration;
	private Bank bank;
	private List<CreditCardStatement> statements = new ArrayList<>();

	@Override
	public void addBalance(Balance balance) {
		getBalance().add(balance);
	}

}

package ar.latorraca.finance.domain.models.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount extends Account {

	private Bank bank;

}

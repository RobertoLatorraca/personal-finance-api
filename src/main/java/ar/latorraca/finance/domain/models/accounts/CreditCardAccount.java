package ar.latorraca.finance.domain.models.accounts;

import java.util.UUID;

import ar.latorraca.finance.domain.models.Bank;
import ar.latorraca.finance.domain.models.Currency;

public class CreditCardAccount extends Account {

	private UUID id;
	private Currency currency;
	private Double cashLimit;
	private Double duesLimit;
	private Balance balance;
	private Bank bank;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Double getCashLimit() {
		return cashLimit;
	}
	
	public void setCashLimit(Double cashLimit) {
		this.cashLimit = cashLimit;
	}
	
	public Double getDuesLimit() {
		return duesLimit;
	}
	
	public void setDuesLimit(Double duesLimit) {
		this.duesLimit = duesLimit;
	}
	
/*	public Balance getBalance() {
		return balance;
	}*/
	
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}

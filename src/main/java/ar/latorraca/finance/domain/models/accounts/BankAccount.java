package ar.latorraca.finance.domain.models.accounts;

import java.util.UUID;

import ar.latorraca.finance.domain.models.Bank;
import ar.latorraca.finance.domain.models.Currency;

public class BankAccount {

	private UUID id;
	private Bank bank;
	private Currency currency;
	private Balance balance;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Balance getBalance() {
		return balance;
	}
	
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
}

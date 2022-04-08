package ar.latorraca.finance.domain.models.accounts;

import java.util.Date;
import java.util.UUID;

import ar.latorraca.finance.domain.models.Currency;

public class Balance {

	private UUID id;
	private Currency currency;
	private Double balance;
	private Date balanceAt;
	
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
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Date getBalanceAt() {
		return balanceAt;
	}
	
	public void setBalanceAt(Date balanceAt) {
		this.balanceAt = balanceAt;
	}
	
}

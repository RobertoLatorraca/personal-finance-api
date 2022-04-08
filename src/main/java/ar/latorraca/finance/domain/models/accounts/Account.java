package ar.latorraca.finance.domain.models.accounts;

import java.util.Date;
import java.util.UUID;

abstract class Account {
	
	private UUID id;
	private String name;
	private Double balance;
	private Date balanceAt;
	private boolean enabled;
	private Date createdAt;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}

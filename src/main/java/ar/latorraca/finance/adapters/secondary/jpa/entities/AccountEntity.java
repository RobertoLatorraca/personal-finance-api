package ar.latorraca.finance.adapters.secondary.jpa.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String account;
	
	@Column(nullable = false)
	private Double balance;
	
	@Column(name = "balance_at", nullable = false)
	private Date balanceAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_account_type", nullable = false)
    private AccountTypeEntity accountType;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bank")
    private BankEntity bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_currency", nullable = false)
    private CurrencyEntity currency;
	
	@Column(nullable = false)
	private boolean enabled = true;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "modified_at")
	private Date modifiedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public AccountTypeEntity getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEntity accountType) {
		this.accountType = accountType;
	}

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
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

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
}

package ar.latorraca.finance.adapters.secondary.jpa.entities;

import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.AccountEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.PayeeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "id", columnDefinition = "varchar(36)")
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_payee", nullable = false)
	private PayeeEntity payee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_account", nullable = false)
	private AccountEntity account;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String type; // values = {INCOME, EXPENSE}

	@Column(nullable = false)
	private Double totalAmount;

	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PayeeEntity getPayee() {
		return payee;
	}

	public void setPayee(PayeeEntity payee) {
		this.payee = payee;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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

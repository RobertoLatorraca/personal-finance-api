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

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.AccountEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.PayeeEntity;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;
	
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

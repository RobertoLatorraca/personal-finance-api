package ar.latorraca.finance.adapters.secondary.jpa.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.AccountEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.PayeeEntity;
import ar.latorraca.finance.domain.models.transaction.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
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

	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type", columnDefinition = "varchar(15)", nullable = false)
	private TransactionType transactionType;

	@Column(name = "total_amount", nullable = false)
	private Double totalAmount;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

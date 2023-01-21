package ar.latorraca.finance.adapters.secondary.jpa.entities.account;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balances")
@Data
@NoArgsConstructor
public class BalanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_account_id", nullable = false)
	private AccountEntity account;

	private Double balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_currency_id", nullable = false)
	private CurrencyEntity currency;

	@Column(name = "balance_at")
	private Date balanceAt;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

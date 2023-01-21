package ar.latorraca.finance.adapters.secondary.jpa.entities.account;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;

	@Column(columnDefinition = "varchar(50)", nullable = false, unique = false)
	private String account;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_currency_id", nullable = false)
	private CurrencyEntity currency;

	@OneToMany(mappedBy = "account")
	private Set<BalanceEntity> balance = new HashSet<>();

	@Column(name = "account_type", columnDefinition = "varchar(20)", nullable = false)
	private String accountType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_bank_id")
	private BankEntity bank;

	@Column(name = "account_number", columnDefinition = "varchar(30)", nullable = true)
	private String accountNumber;

	@Column(name = "cbu", columnDefinition = "varchar(22)", nullable = true)
	private String cbu;

	@Column(name = "alias", columnDefinition = "varchar(30)", nullable = true)
	private String alias;

	@Column(name = "credit_card_brand", columnDefinition = "varchar(20)", nullable = true)
	private String creditCardBrand;

	@Column(name = "credit_card_number", columnDefinition = "varchar(19)", nullable = true)
	private String creditCardNumber;

	private Date expiration;

	@Column(nullable = false)
	private boolean enabled = true;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

package ar.latorraca.finance.adapters.secondary.jpa.entities.account;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

//	@Transient
	@OneToMany(mappedBy = "account")
	private Set<BalanceEntity> balance = new HashSet<>();

	@Column(name = "account_type", columnDefinition = "varchar(20)", nullable = false)
	private String accountType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_bank_id")
	private BankEntity bank;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_currency_id", nullable = false)
	private CurrencyEntity currency;

	@Column(nullable = false)
	private boolean enabled = true;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

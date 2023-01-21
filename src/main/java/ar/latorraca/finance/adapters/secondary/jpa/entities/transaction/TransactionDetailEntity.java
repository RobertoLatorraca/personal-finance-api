package ar.latorraca.finance.adapters.secondary.jpa.entities.transaction;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import ar.latorraca.finance.domain.models.transaction.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_details")
@Data
@NoArgsConstructor
public class TransactionDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_transaction_id", nullable = false)
	private TransactionEntity transaction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_category_id", nullable = false)
	private CategoryEntity category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tag_id", nullable = false)
	private TagEntity tag;

	@Column(columnDefinition = "varchar(255)")
	private String memo;

	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type", columnDefinition = "varchar(15)", nullable = false)
	private TransactionType transactionType;

	private Double amount;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

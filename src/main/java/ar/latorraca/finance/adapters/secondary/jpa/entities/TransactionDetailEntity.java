package ar.latorraca.finance.adapters.secondary.jpa.entities;

import org.hibernate.annotations.UuidGenerator;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.CategoryEntity;
import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TagEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionDetailEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "id", columnDefinition = "varchar(36)")
	private String id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_transaction", nullable = false)
    private TransactionEntity transaction;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_category", nullable = false)
    private CategoryEntity category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tag", nullable = false)
    private TagEntity tag;
    
    private String memo;
    
    private Double amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TransactionEntity getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public TagEntity getTag() {
		return tag;
	}

	public void setTag(TagEntity tag) {
		this.tag = tag;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
}

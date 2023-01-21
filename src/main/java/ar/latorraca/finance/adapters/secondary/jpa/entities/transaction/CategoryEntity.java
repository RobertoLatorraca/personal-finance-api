package ar.latorraca.finance.adapters.secondary.jpa.entities.transaction;

import java.sql.Timestamp;
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
@Table(name = "categories")
@Data
@NoArgsConstructor
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;

	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String categoryType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_id")
	private CategoryEntity parentCategory;

	@Column(columnDefinition = "varchar(255)")
	private String description;

	@Column(nullable = false)
	private boolean enabled = true;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}

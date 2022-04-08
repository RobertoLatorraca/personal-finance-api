package ar.latorraca.finance.adapters.secondary.jpa.entities;

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
@Table(name = "categories")
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group", nullable = false)
    private CategoryGroupEntity groups;
	
	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String type; // values = {INCOME, EXPENSE}
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CategoryEntity parentCategory;
	
	@Column(columnDefinition = "varchar(255)")
	private String description;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public CategoryGroupEntity getGroups() {
		return groups;
	}

	public void setGroups(CategoryGroupEntity groups) {
		this.groups = groups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CategoryEntity getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(CategoryEntity parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

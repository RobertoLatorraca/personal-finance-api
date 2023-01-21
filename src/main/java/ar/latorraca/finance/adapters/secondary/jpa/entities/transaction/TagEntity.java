package ar.latorraca.finance.adapters.secondary.jpa.entities.transaction;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tags")
@Data
@NoArgsConstructor
public class TagEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "id", columnDefinition = "varchar(36)")
	private String id;

	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String tag;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_tag_id")
	private TagEntity parentTag;

	@Column(nullable = false)
	private boolean enabled = true;

	@CreationTimestamp	
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private Timestamp modifiedAt;

}
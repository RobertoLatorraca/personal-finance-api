package ar.latorraca.finance.adapters.secondary.jpa.entities.transaction;

import java.sql.Timestamp;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tags")
@Data
@NoArgsConstructor
public class TagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;

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
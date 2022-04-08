package ar.latorraca.finance.adapters.secondary.jpa.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private TagEntity parentTag;
	
	@Column(nullable = false)
	private boolean enabled = true;

}
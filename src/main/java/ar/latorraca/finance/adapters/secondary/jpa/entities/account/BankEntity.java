package ar.latorraca.finance.adapters.secondary.jpa.entities.account;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banks")
@Data
@NoArgsConstructor
public class BankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private boolean enabled = true;
	
}

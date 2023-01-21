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
@Table(name = "currencies")
@Data
@NoArgsConstructor
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.hibernate.annotations.Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "varchar(36)")
	private UUID id;
	
	@Column(columnDefinition = "varchar(3)", nullable = false, unique = false)
	private String cca3;
	
	@Column(columnDefinition = "varchar(100)", nullable = false, unique = false)
	private String country;
	
	@Column(columnDefinition = "varchar(25)", nullable = false, unique = true)
	private String currency;

	@Column(columnDefinition = "varchar(3)", nullable = false, unique = false)
	private String code;

	@Column(columnDefinition = "varchar(1)", nullable = true, unique = false)
	private String symbol;
	
	@Column(name = "exchange_rate", columnDefinition = "double", nullable = false)
	private double exchangeRate;
	
	@Column(nullable = false)
	private boolean enabled = true;

}

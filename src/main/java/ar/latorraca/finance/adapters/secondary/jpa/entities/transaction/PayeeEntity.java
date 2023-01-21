package ar.latorraca.finance.adapters.secondary.jpa.entities.transaction;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payees")
@Data
@NoArgsConstructor
public class PayeeEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "id", columnDefinition = "varchar(36)")
	private String id;
	
	@Column(columnDefinition = "varchar(150)", nullable = false, unique = true)
	private String name;

}
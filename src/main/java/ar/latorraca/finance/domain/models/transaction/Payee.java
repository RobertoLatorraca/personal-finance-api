package ar.latorraca.finance.domain.models.transaction;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payee {

	private UUID id;
	private String name;
	
}

package ar.latorraca.finance.domain.models.account;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bank {

	private UUID id;
	private String name;
	private boolean enabled;
	
}

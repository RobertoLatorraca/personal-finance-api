package ar.latorraca.finance.domain.models.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bank {

	private String id;
	private String name;
	private boolean enabled;
	
}

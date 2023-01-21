package ar.latorraca.finance.adapters.primary.rest.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankDto {

	private String id;
	private String name;
	private boolean enabled = true;

}

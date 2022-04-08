package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankDto {

	private UUID id;
	private String name;
	private boolean enabled = true;

}

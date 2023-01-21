package ar.latorraca.finance.adapters.primary.rest.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CurrencyDto {

	private String id;
	private String cca3;
	private String country;
	private String currency;
	private String code;
	private String symbol;
	private double exchangeRate;
	private boolean enabled = true;
	
}

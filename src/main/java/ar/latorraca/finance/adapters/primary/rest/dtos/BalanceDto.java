package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDto {

	private String id;
	private Double balance;
	private CurrencyDto currency;
	private Date balanceAt;

}

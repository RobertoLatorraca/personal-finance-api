package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDto {

	private UUID id;
	private Double balance;
	private CurrencyDto currency;
	private Date balanceAt;

}

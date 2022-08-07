package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import ar.latorraca.finance.domain.models.account.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

	private UUID id;
	private String account;
	private AccountType accountType;
	private CurrencyDto currency;

	@JsonProperty(access = Access.READ_ONLY)
	private Set<BalanceDto> balance;

	private BankDto bank;
	private boolean enabled = true;

}

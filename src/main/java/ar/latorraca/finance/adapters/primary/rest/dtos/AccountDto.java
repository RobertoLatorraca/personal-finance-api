package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.latorraca.finance.domain.models.account.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDto {

	private UUID id;
	private String account;
	private AccountType accountType;
	private CurrencyDto currency;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Set<BalanceDto> balance;

	private BankDto bank;
	private boolean enabled = true;

}

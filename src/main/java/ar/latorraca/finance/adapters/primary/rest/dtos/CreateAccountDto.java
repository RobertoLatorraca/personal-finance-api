package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.latorraca.finance.domain.models.account.AccountType;
import ar.latorraca.finance.domain.models.account.CreditCardBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountDto {

	private String id;
	private String account;
	private AccountType accountType;
	private CurrencyDto currency;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Set<BalanceDto> balance;

	private BankDto bank;
	private String accountNumber;
	private String cbu;
	private String alias;

	private CreditCardBrand creditCardBrand;
	private String creditCardNumber;
	private Date expiration;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Boolean enabled = true;

}

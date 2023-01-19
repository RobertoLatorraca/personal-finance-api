package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.latorraca.finance.domain.models.transaction.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDto {

	private UUID id;

	@NotNull
	private PayeeDto payee;

	@NotNull
	private AccountDto account;

	@NotNull
	private Date date;

	@NotNull
	private CurrencyDto currency;

	@NotNull
	private Double totalAmount;

	private TransactionType transactionType;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private TransactionDto relatedTransaction; // For TRANSFERS

	@Valid
	@NotNull
	private Set<TransactionDetailDto> transactionDetail;

	private String notes;
	private Boolean flag;

}

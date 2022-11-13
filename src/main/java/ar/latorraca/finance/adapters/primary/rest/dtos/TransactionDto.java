package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import ar.latorraca.finance.domain.models.transaction.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

	private UUID id;

	@NotNull
	private PayeeDto payee;

	@NotNull
	private AccountDto account;

	@NotNull
	private Date date;

	@NotNull
	private Double totalAmount;

	private TransactionType transactionType;
	private TransactionDto relatedTransaction; // For TRANSFERS

//	@NotNull FOR TEST TRANSACTION PERSISTENCE
	private Set<TransactionDetailDto> transactionDetail;

	private String notes;
	private Boolean flag;

}

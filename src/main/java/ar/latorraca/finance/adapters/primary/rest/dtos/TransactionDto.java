package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import ar.latorraca.finance.domain.models.transaction.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

	private UUID id;
	private PayeeDto payee;
	private AccountDto account;
	private Date date;
	private Double totalAmount;
	private TransactionType transactionType;
	private TransactionDto relatedTransaction;
	private Set<TransactionDetailDto> transactionDetail;
	private String notes;
	private Boolean flag;

}

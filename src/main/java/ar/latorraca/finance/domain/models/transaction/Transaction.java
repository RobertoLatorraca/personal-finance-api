package ar.latorraca.finance.domain.models.transaction;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {

	private UUID id;
	private Payee payee;
	private Account account;
	private Date date;
	private Currency currency;
	private Double totalAmount;
	private TransactionType transactionType;
	private Transaction relatedTransaction;
	private Set<TransactionDetail> transactionDetail;
	private String notes;
	private Boolean flag;

}

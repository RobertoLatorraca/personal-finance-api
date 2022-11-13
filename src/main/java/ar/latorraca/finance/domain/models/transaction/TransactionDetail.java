package ar.latorraca.finance.domain.models.transaction;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetail {

	private UUID id;
	private Category category;
	private Tag tag;
	private String memo;
	private TransactionType transactionType;
	private Double amount;

}

package ar.latorraca.finance.domain.models.account;

import java.util.Date;

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
public class Balance {

	private String id;
	private Double balance;
	private Currency currency;
	private Date balanceAt;

}

package ar.latorraca.finance.domain.models.account;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardStatement {

	private Date closing;
	private Date nextClosing;	
	private Date expiration;
	private Set<Balance> balance;

}

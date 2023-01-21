package ar.latorraca.finance.domain.models.account;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Currency {

	private String id;
	private String cca3;
	private String country;
	private String currency;
	private String code;
	private String symbol;
	private double exchangeRate;
	private boolean enabled;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Currency other = (Currency) obj;
		return Objects.equals(currency, other.getCurrency()) &&
				Objects.equals(code, other.getCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash *= 23;
		hash += this.currency != null ? this.currency.hashCode() : 0;
		hash *= 37;
		hash += this.code != null ? this.code.hashCode() : 0;
		return hash;
	}

}

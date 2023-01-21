package ar.latorraca.finance.domain.ports.in.account;

import java.util.List;
import java.util.Optional;

import ar.latorraca.finance.domain.models.account.Currency;

public interface CurrencyService {

	Currency save(Currency currency);
	
	Currency update(String id, Currency currency);
	
	List<Currency> findAll();
	
	Optional<Currency> findById(String id);
	
	void deleteById(String id);

}

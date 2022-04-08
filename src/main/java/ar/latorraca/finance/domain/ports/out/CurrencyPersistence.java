package ar.latorraca.finance.domain.ports.out;

import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.Currency;

public interface CurrencyPersistence {

	Currency save(Currency currency);
	
	Iterable<Currency> findAll();
	
	Optional<Currency> findById(UUID id);
	
	void deleteById(UUID id);
	
	Optional<Currency> findByCurrencyOrCode(String currency, String code);
	
}

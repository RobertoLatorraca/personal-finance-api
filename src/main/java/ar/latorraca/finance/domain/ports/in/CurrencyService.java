package ar.latorraca.finance.domain.ports.in;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.Currency;

public interface CurrencyService {

	Currency save(Currency currency);
	
	Currency update(UUID id, Currency currency);
	
	List<Currency> findAll();
	
	Optional<Currency> findById(UUID id);
	
	void deleteById(UUID id);

}

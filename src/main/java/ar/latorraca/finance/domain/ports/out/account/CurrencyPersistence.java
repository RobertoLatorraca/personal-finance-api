package ar.latorraca.finance.domain.ports.out.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.account.Currency;

public interface CurrencyPersistence {

	Currency save(Currency currency);
	
	List<Currency> findAll(Sort sort);
	
	Optional<Currency> findById(String id);
	
	void deleteById(String id);
	
	Optional<Currency> findByCurrencyOrCode(String currency, String code);
	
}

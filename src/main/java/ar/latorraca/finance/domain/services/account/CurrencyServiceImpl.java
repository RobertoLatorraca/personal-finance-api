package ar.latorraca.finance.domain.services.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Currency;
import ar.latorraca.finance.domain.ports.in.account.CurrencyService;
import ar.latorraca.finance.domain.ports.out.account.CurrencyPersistence;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private final int TRUE = 0;

	@Autowired
	private CurrencyPersistence currencyPersistence;

	@Override
	public Currency save(Currency currency) {
		// TODO
		// Validar propiedades del objeto (vacias, etc)
		checkForDuplicateCurrencies(currency, false);
		return currencyPersistence.save(currency);
	}

	@Override
	public Currency update(String id, Currency currency) {
		if (currencyPersistence.findById(id).isEmpty()) throw new NotFoundException();
		checkForDuplicateCurrencies(currency, true);
		currency.setId(id);
		return currencyPersistence.save(currency);
	}

	@Override
	public List<Currency> findAll() {
		return currencyPersistence.findAll(Sort.by(Direction.ASC, "currency"));
	}

	@Override
	public Optional<Currency> findById(String id) {
		return currencyPersistence.findById(id);
	}

	@Override
	public void deleteById(String id) {
		currencyPersistence.deleteById(id);
	}
	
	private void checkForDuplicateCurrencies(Currency currency, boolean isUpdating) {
		Optional<Currency> currencyDb = currencyPersistence.findByCurrencyOrCode(currency.getCurrency(), currency.getCode());
		if (currencyDb.isEmpty()) return;
		if (isUpdating && currencyDb.get().getId().compareTo(currency.getId()) == TRUE) return;
		if (currencyDb.get().equals(currency))
				throw new FieldAlreadyExistException(currency.getCurrency() + " " + currency.getCode());
	}

}

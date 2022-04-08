package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.Currency;
import ar.latorraca.finance.domain.ports.in.CurrencyService;
import ar.latorraca.finance.domain.ports.out.CurrencyPersistence;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	
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
	public Currency update(UUID id, Currency currency) {
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
	public Optional<Currency> findById(UUID id) {
		return currencyPersistence.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		currencyPersistence.deleteById(id);
	}
	
	private void checkForDuplicateCurrencies(Currency currency, boolean isUpdating) {
		Optional<Currency> currencyDb = currencyPersistence.findByCurrencyOrCode(currency.getCurrency(), currency.getCode());
		if (currencyDb.isEmpty()) return;
		if (isUpdating && currency.getId() == currencyDb.get().getId()) return;
		if (currencyDb.get().equals(currency))
				throw new FieldAlreadyExistException(currency.getCurrency() + " " + currency.getCode());
	}

}

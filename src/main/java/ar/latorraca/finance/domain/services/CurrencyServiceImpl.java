package ar.latorraca.finance.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.primary.rest.dtos.CurrencyDto;
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
	public CurrencyDto save(CurrencyDto currencyDto) {
		// TODO
		// Validar propiedades del objeto (vacias, etc)
		checkForDuplicateCurrencies(currencyDto, false);
		Currency currencyDB = new ModelMapper().map(currencyDto, Currency.class);
		return new ModelMapper().map(currencyPersistence.save(currencyDB), CurrencyDto.class);
	}

	@Override
	public CurrencyDto update(CurrencyDto currencyDto) {
		if (currencyPersistence.findById(currencyDto.getId()).isEmpty()) throw new NotFoundException();
		checkForDuplicateCurrencies(currencyDto, true);
		Currency currencyDB = new ModelMapper().map(currencyDto, Currency.class);
		return new ModelMapper().map(currencyPersistence.save(currencyDB), CurrencyDto.class);
	}

	@Override
	public Iterable<CurrencyDto> findAll() {
		List<CurrencyDto> result = new ArrayList<>();
		currencyPersistence.findAll().forEach(currency ->
				result.add(new ModelMapper().map(currency, CurrencyDto.class)));
		result.sort((CurrencyDto c1, CurrencyDto c2) -> c1.getCurrency().compareTo(c2.getCurrency()));
		return result;
	}

	@Override
	public CurrencyDto findById(UUID id) {
		Optional<Currency> currency = currencyPersistence.findById(id);
		if (currency.isPresent()) {
			return new ModelMapper().map(currency.get(), CurrencyDto.class);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(UUID id) {
		currencyPersistence.deleteById(id);
	}
	
	private void checkForDuplicateCurrencies(CurrencyDto currencyDto, boolean isUpdating) {
		Optional<Currency> currencyDb = currencyPersistence.findByCurrencyOrCode(currencyDto.getCurrency(), currencyDto.getCode());
		if (currencyDb.isEmpty()) return;
		if (isUpdating && currencyDto.getId() == currencyDb.get().getId()) return;
		if (currencyDb.get().equals(new ModelMapper().map(currencyDto, Currency.class)))
				throw new FieldAlreadyExistException(currencyDto.getCurrency() + " " + currencyDto.getCode());
	}

}

package ar.latorraca.finance.domain.ports.in;

import java.util.UUID;

import ar.latorraca.finance.adapters.primary.rest.dtos.CurrencyDto;

public interface CurrencyService {

	CurrencyDto save(CurrencyDto currencyDto);
	
	CurrencyDto update(CurrencyDto currencyDto);
	
	Iterable<CurrencyDto> findAll();
	
	CurrencyDto findById(UUID id);
	
	void deleteById(UUID id);

}

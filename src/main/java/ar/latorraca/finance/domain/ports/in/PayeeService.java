package ar.latorraca.finance.domain.ports.in;

import java.util.UUID;

import ar.latorraca.finance.adapters.primary.rest.dtos.PayeeDto;

public interface PayeeService {

	PayeeDto save(PayeeDto payeeDto);
	
	PayeeDto update(PayeeDto payeeDto);
	
	Iterable<PayeeDto> findAll();
	
	PayeeDto findById(UUID id);
	
	void deleteById(UUID id);
	
}

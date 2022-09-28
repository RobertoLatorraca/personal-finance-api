package ar.latorraca.finance.domain.ports.in.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.transaction.Payee;

public interface PayeeService {

	Payee save(Payee payee);
	
	Payee update(UUID id, Payee payee);
	
	List<Payee> findAll();
	
	Optional<Payee> findById(UUID id);
	
	void deleteById(UUID id);
	
}

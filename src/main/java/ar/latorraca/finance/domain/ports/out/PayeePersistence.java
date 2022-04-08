package ar.latorraca.finance.domain.ports.out;

import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.Payee;

public interface PayeePersistence {

	Payee save(Payee payee);
	
	Iterable<Payee> findAll();
	
	Optional<Payee> findById(UUID id);
	
	void deleteById(UUID id);
	
	Optional<Payee> findByName(String name);
	
}

package ar.latorraca.finance.domain.ports.out.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.transaction.Payee;

public interface PayeePersistence {

	Payee save(Payee payee);
	
	List<Payee> findAll(Sort sort);
	
	Optional<Payee> findById(UUID id);
	
	void deleteById(UUID id);
	
	Optional<Payee> findByName(String name);
	
}

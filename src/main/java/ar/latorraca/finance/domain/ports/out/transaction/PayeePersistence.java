package ar.latorraca.finance.domain.ports.out.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.transaction.Payee;

public interface PayeePersistence {

	Payee save(Payee payee);
	
	List<Payee> findAll(Sort sort);
	
	Optional<Payee> findById(String id);
	
	void deleteById(String id);
	
	Optional<Payee> findByName(String name);
	
}

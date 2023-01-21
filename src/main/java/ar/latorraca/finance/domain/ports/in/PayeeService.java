package ar.latorraca.finance.domain.ports.in;

import java.util.List;
import java.util.Optional;

import ar.latorraca.finance.domain.models.transaction.Payee;

public interface PayeeService {

	Payee save(Payee payee);
	
	Payee update(String id, Payee payee);
	
	List<Payee> findAll();
	
	Optional<Payee> findById(String id);
	
	void deleteById(String id);
	
}

package ar.latorraca.finance.domain.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.Bank;

public interface BankPersistence {

	Bank save(Bank bank);
	
	List<Bank> findAll(Sort sort);
	
	Optional<Bank> findById(UUID id);
	
	void deleteById(UUID id);
	
	Optional<Bank> findByName(String name);
	
}

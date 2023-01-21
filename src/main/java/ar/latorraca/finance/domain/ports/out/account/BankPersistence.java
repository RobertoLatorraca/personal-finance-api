package ar.latorraca.finance.domain.ports.out.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.account.Bank;

public interface BankPersistence {

	Bank save(Bank bank);
	
	List<Bank> findAll(Sort sort);
	
	Optional<Bank> findById(String id);
	
	void deleteById(String id);
	
	Optional<Bank> findByName(String name);
	
}

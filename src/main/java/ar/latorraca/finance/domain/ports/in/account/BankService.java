package ar.latorraca.finance.domain.ports.in.account;

import java.util.List;
import java.util.Optional;

import ar.latorraca.finance.domain.models.account.Bank;

public interface BankService {

	Bank save(Bank bank);
	
	Bank update(String id, Bank bank);
	
	List<Bank> findAll();
	
	Optional<Bank> findById(String id);
	
	void deleteById(String id);
	
}

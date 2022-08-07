package ar.latorraca.finance.domain.ports.in.account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.account.Bank;

public interface BankService {

	Bank save(Bank bank);
	
	Bank update(UUID id, Bank bank);
	
	List<Bank> findAll();
	
	Optional<Bank> findById(UUID id);
	
	void deleteById(UUID id);
	
}

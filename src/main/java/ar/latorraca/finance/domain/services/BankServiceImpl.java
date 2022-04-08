package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.Bank;
import ar.latorraca.finance.domain.ports.in.BankService;
import ar.latorraca.finance.domain.ports.out.BankPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankPersistence bankPersistence;
	
	@Override
	public Bank save(Bank bank) {
		if (bank.getName() == null || bank.getName().equals(""))
				throw new BadRequestException("Bank name cannot be empty");
		if (bankPersistence.findByName(bank.getName()).isPresent()) 
				throw new FieldAlreadyExistException(bank.getName());
		return bankPersistence.save(bank);
	}

	@Override
	public Bank update(UUID id, Bank bank) {
		if (bankPersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Bank> bankTestForDuplicates = bankPersistence.findByName(bank.getName());
		if (bankTestForDuplicates.isPresent() && bankTestForDuplicates.get().getId() != bank.getId())
				throw new FieldAlreadyExistException(bank.getName());
		bank.setId(id);
		return bankPersistence.save(bank);
	}
	
	@Override
	public List<Bank> findAll() {
		return bankPersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Optional<Bank> findById(UUID id) {
		return bankPersistence.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		bankPersistence.deleteById(id);
	}

}
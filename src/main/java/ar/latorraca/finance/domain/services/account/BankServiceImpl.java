package ar.latorraca.finance.domain.services.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.account.Bank;
import ar.latorraca.finance.domain.ports.in.account.BankService;
import ar.latorraca.finance.domain.ports.out.account.BankPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class BankServiceImpl implements BankService {

	private final int TRUE = 0;

	@Autowired
	private BankPersistence bankPersistence;
	
	@Override
	public Bank save(Bank bank) {
		if (bank.getName() == null || bank.getName().equals(""))
				throw new BadRequestException("Bank name must not be empty.");
		if (bankPersistence.findByName(bank.getName()).isPresent()) 
				throw new FieldAlreadyExistException(bank.getName());
		return bankPersistence.save(bank);
	}

	@Override
	public Bank update(String id, Bank bank) {
		if (bankPersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Bank> bankTestForDuplicates = bankPersistence.findByName(bank.getName());
		if (bankTestForDuplicates.isPresent() && bankTestForDuplicates.get().getId().compareTo(bank.getId()) != TRUE)
				throw new FieldAlreadyExistException(bank.getName());
		bank.setId(id);
		return bankPersistence.save(bank);
	}
	
	@Override
	public List<Bank> findAll() {
		return bankPersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Optional<Bank> findById(String id) {
		return bankPersistence.findById(id);
	}

	@Override
	public void deleteById(String id) {
		bankPersistence.deleteById(id);
	}

}
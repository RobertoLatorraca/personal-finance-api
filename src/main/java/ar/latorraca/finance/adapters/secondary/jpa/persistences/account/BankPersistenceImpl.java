package ar.latorraca.finance.adapters.secondary.jpa.persistences.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.BankEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.account.BankRepository;
import ar.latorraca.finance.domain.models.account.Bank;
import ar.latorraca.finance.domain.ports.out.account.BankPersistence;

@Service
public class BankPersistenceImpl implements BankPersistence {

	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public Bank save(Bank bank) {
		BankEntity bankEntity = new ModelMapper().map(bank, BankEntity.class);
		return new ModelMapper().map(bankRepository.save(bankEntity), Bank.class);
	}

	@Override
	public List<Bank> findAll(Sort sort) {
		List<Bank> result = new ArrayList<>();
		bankRepository.findAll(sort).forEach(bankEntity -> {
			result.add(new ModelMapper().map(bankEntity, Bank.class));
		});
		return result;
	}

	@Override
	public Optional<Bank> findById(UUID id) {
		Optional<BankEntity> bankEntity = bankRepository.findById(id);
		if (bankEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(bankEntity.get(), Bank.class));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void deleteById(UUID id) {
		bankRepository.deleteById(id);		
	}

	@Override
	public Optional<Bank> findByName(String name) {
		Optional<BankEntity> bankEntity = bankRepository.findByName(name);
		if (bankEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(bankEntity.get(), Bank.class));
		} else {
			return Optional.empty();
		}
	}

}
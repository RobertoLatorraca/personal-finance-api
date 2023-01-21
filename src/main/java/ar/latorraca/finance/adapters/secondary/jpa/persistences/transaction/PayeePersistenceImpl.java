package ar.latorraca.finance.adapters.secondary.jpa.persistences.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.PayeeEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction.PayeeRepository;
import ar.latorraca.finance.domain.models.transaction.Payee;
import ar.latorraca.finance.domain.ports.out.transaction.PayeePersistence;

@Service
public class PayeePersistenceImpl implements PayeePersistence {
	
	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public Payee save(Payee payee) {
		PayeeEntity payeeEntity = new ModelMapper().map(payee, PayeeEntity.class);
		return new ModelMapper().map(payeeRepository.save(payeeEntity), Payee.class);
	}

	@Override
	public List<Payee> findAll(Sort sort) {
		List<Payee> result = new ArrayList<>();
		payeeRepository.findAll(sort).forEach(payeeEntity -> {
			result.add(new ModelMapper().map(payeeEntity, Payee.class));
		});
		return result;
	}

	@Override
	public Optional<Payee> findById(String id) {
		Optional<PayeeEntity> payeeEntity = payeeRepository.findById(id);
		if (payeeEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(payeeEntity.get(), Payee.class));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void deleteById(String id) {
		payeeRepository.deleteById(id);
	}

	@Override
	public Optional<Payee> findByName(String name) {
		Optional<PayeeEntity> payeeEntity = payeeRepository.findByName(name);
		if (payeeEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(payeeEntity.get(), Payee.class));
		} else {
			return Optional.empty();
		}
	}

}

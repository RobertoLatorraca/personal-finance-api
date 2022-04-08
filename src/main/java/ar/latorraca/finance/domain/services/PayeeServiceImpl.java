package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.Payee;
import ar.latorraca.finance.domain.ports.in.PayeeService;
import ar.latorraca.finance.domain.ports.out.PayeePersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeePersistence payeePersistence;
	
	@Override
	public Payee save(Payee payee) {
		if (payee.getName() == null || payee.getName().equals(""))
			throw new BadRequestException("Payee name cannot be empty");
		if (payeePersistence.findByName(payee.getName()).isPresent()) 
			throw new FieldAlreadyExistException(payee.getName());
		return payeePersistence.save(payee);
	}

	@Override
	public Payee update(UUID id, Payee payee) {
		if (payeePersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Payee> payeeTestForDuplicates = payeePersistence.findByName(payee.getName());
		if (payeeTestForDuplicates.isPresent() && payeeTestForDuplicates.get().getId() != payee.getId())
				throw new FieldAlreadyExistException(payee.getName());
		payee.setId(id);
		return payeePersistence.save(payee);
	}

	@Override
	public List<Payee> findAll() {
		return payeePersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Optional<Payee> findById(UUID id) {
		return payeePersistence.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		payeePersistence.deleteById(id);
	}

}

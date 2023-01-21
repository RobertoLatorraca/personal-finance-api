package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.transaction.Payee;
import ar.latorraca.finance.domain.ports.in.PayeeService;
import ar.latorraca.finance.domain.ports.out.transaction.PayeePersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class PayeeServiceImpl implements PayeeService {

	private final int TRUE = 0;

	@Autowired
	private PayeePersistence payeePersistence;
	
	@Override
	public Payee save(Payee payee) {
		if (payee.getName() == null || payee.getName().equals(""))
			throw new BadRequestException("Payee name must not be empty.");
		if (payeePersistence.findByName(payee.getName()).isPresent()) 
			throw new FieldAlreadyExistException(payee.getName());
		return payeePersistence.save(payee);
	}

	@Override
	public Payee update(String id, Payee payee) {
		if (payeePersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Payee> payeeTestForDuplicates = payeePersistence.findByName(payee.getName());
		if (payeeTestForDuplicates.isPresent() && payeeTestForDuplicates.get().getId().compareTo(payee.getId()) != TRUE)
				throw new FieldAlreadyExistException(payee.getName());
		payee.setId(id);
		return payeePersistence.save(payee);
	}

	@Override
	public List<Payee> findAll() {
		return payeePersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Optional<Payee> findById(String id) {
		return payeePersistence.findById(id);
	}

	@Override
	public void deleteById(String id) {
		payeePersistence.deleteById(id);
	}

}

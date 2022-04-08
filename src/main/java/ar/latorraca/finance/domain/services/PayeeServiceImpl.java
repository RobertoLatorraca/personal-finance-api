package ar.latorraca.finance.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.primary.rest.dtos.PayeeDto;
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
	public PayeeDto save(PayeeDto payeeDto) {
		if (payeeDto.getName() == null || payeeDto.getName().equals(""))
			throw new BadRequestException("Payee name cannot be empty");
		if (payeePersistence.findByName(payeeDto.getName()).isPresent()) 
			throw new FieldAlreadyExistException(payeeDto.getName());
		Payee payeeDb = new ModelMapper().map(payeeDto, Payee.class);
		return new ModelMapper().map(payeePersistence.save(payeeDb), PayeeDto.class);
	}

	@Override
	public PayeeDto update(PayeeDto payeeDto) {
		if (payeePersistence.findById(payeeDto.getId()).isEmpty()) throw new NotFoundException();
		Optional<Payee> payeeOptional = payeePersistence.findByName(payeeDto.getName());
		if (payeeOptional.isPresent() && payeeOptional.get().getId() != payeeDto.getId())
				throw new FieldAlreadyExistException(payeeDto.getName());
		Payee payeeDb = new ModelMapper().map(payeeDto, Payee.class);
		return new ModelMapper().map(payeePersistence.save(payeeDb), PayeeDto.class);
	}

	@Override
	public Iterable<PayeeDto> findAll() {
		List<PayeeDto> result = new ArrayList<>();
		payeePersistence.findAll().forEach(payee ->
				result.add(new ModelMapper().map(payee, PayeeDto.class)));
		result.sort((PayeeDto p1, PayeeDto p2) -> p1.getName().compareTo(p2.getName()));
		return result;
	}

	@Override
	public PayeeDto findById(UUID id) {
		Optional<Payee> payee = payeePersistence.findById(id);
		if (payee.isPresent()) {
			return new ModelMapper().map(payee.get(), PayeeDto.class);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(UUID id) {
		payeePersistence.deleteById(id);
	}

}

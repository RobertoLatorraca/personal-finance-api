package ar.latorraca.finance.adapters.primary.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.PayeeDto;
import ar.latorraca.finance.domain.models.transaction.Payee;
import ar.latorraca.finance.domain.ports.in.transaction.PayeeService;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(PayeeController.PAYEES)
public class PayeeController {

	protected static final String PAYEES = "/payees";
	private static final String ID = "/{id}";

	@Autowired
	private PayeeService payeeService;
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody PayeeDto payeeDto) {
		if (payeeDto.getId() != null) {
			throw new BadRequestException(payeeDto.toString());
		}
		Payee payee = new ModelMapper().map(payeeDto, Payee.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ModelMapper().map(payeeService.save(payee), PayeeDto.class));
	}
	
	@PutMapping(ID)
	public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody PayeeDto payeeDto) {
		Payee payee = new ModelMapper().map(payeeDto, Payee.class);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ModelMapper().map(payeeService.update(id, payee), PayeeDto.class));
	}
	
	@GetMapping()
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				payeeService.findAll().stream().map(
						p -> new ModelMapper().map(p, PayeeDto.class))
				.collect(Collectors.toList()));
	}
	
	@GetMapping(ID)
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Optional<Payee> result = payeeService.findById(id);
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new ModelMapper().map(result.get(), PayeeDto.class));
	}
	
	@DeleteMapping(ID)
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		payeeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

package ar.latorraca.finance.adapters.primary.rest;

import java.util.UUID;

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
import ar.latorraca.finance.domain.ports.in.PayeeService;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(PayeeController.PAYEES)
public class PayeeController {

	public static final String PAYEES = "/payees";
	public static final String ID = "/{id}";

	@Autowired
	private PayeeService payeeService;
	
	@PostMapping()
	public ResponseEntity<PayeeDto> save(@RequestBody PayeeDto payeeDto) {
		if (payeeDto.getId() != null) {
			throw new BadRequestException(payeeDto.toString());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(payeeService.save(payeeDto));
	}
	
	@PutMapping() // TODO el id debe ir en la url segun buenas practicas de REST
	public ResponseEntity<PayeeDto> update(@RequestBody PayeeDto payeeDto) {
		if (payeeDto.getId() == null) throw new BadRequestException(payeeDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(payeeService.update(payeeDto));
	}
	
	@GetMapping()
	public ResponseEntity<Iterable<PayeeDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(payeeService.findAll());
	}
	
	@GetMapping(ID)
	public ResponseEntity<PayeeDto> findById(@PathVariable UUID id) {
		PayeeDto payee = payeeService.findById(id);
		if (payee == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(payee);
	}
	
	@DeleteMapping(ID)
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		payeeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

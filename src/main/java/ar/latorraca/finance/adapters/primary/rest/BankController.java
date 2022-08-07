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

import ar.latorraca.finance.adapters.primary.rest.dtos.BankDto;
import ar.latorraca.finance.domain.models.account.Bank;
import ar.latorraca.finance.domain.ports.in.account.BankService;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(BankController.BANKS)
public class BankController {

	protected static final String BANKS = "/banks";
	private static final String ID = "/{id}";

	@Autowired
	private BankService bankService;
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody BankDto bankDto) {
		if (bankDto.getId() != null || bankDto.isEnabled() == false) {
			throw new BadRequestException(bankDto.toString());
		}
		Bank bank = new ModelMapper().map(bankDto, Bank.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ModelMapper().map(bankService.save(bank), BankDto.class));
	}
	
	@PutMapping(ID)
	public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody BankDto bankDto) {
		Bank bank = new ModelMapper().map(bankDto, Bank.class);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ModelMapper().map(bankService.update(id, bank), BankDto.class));
	}
	
	@GetMapping()
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				bankService.findAll().stream().map(
						b -> new ModelMapper().map(b, BankDto.class))
				.collect(Collectors.toList()));
	}
	
	@GetMapping(ID)
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Optional<Bank> result = bankService.findById(id);
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new ModelMapper().map(result.get(), BankDto.class));
	}
	
	@DeleteMapping(ID)
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		bankService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

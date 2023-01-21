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

import ar.latorraca.finance.adapters.primary.rest.dtos.CurrencyDto;
import ar.latorraca.finance.domain.models.account.Currency;
import ar.latorraca.finance.domain.ports.in.account.CurrencyService;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(CurrencyController.CURRENCY)
public class CurrencyController {

	protected static final String CURRENCY = "/currencies";
	private static final String ID = "/{id}";
	
	@Autowired
	private CurrencyService currencyService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CurrencyDto currencyDto) {
		if (currencyDto.getId() != null || currencyDto.isEnabled() == false) {
			throw new BadRequestException(currencyDto.toString());
		}
		Currency currency = new ModelMapper().map(currencyDto, Currency.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ModelMapper().map(currencyService.save(currency), CurrencyDto.class));
	}
	
	@PutMapping(ID)
	public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody CurrencyDto currencyDto) {
		Currency currency = new ModelMapper().map(currencyDto, Currency.class);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ModelMapper().map(currencyService.update(id.toString(), currency), CurrencyDto.class));
	}
	
	@GetMapping()
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(currencyService.findAll().stream().map(
						c -> new ModelMapper().map(c, CurrencyDto.class))
				.collect(Collectors.toList()));
	}
	
	@GetMapping(ID)
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Optional<Currency> result = currencyService.findById(id.toString());
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new ModelMapper().map(result.get(), CurrencyDto.class));
	}
	
	@DeleteMapping(ID)
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		currencyService.deleteById(id.toString());
		return ResponseEntity.noContent().build();
	}

}

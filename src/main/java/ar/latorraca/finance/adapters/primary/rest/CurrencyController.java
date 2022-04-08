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

import ar.latorraca.finance.adapters.primary.rest.dtos.CurrencyDto;
import ar.latorraca.finance.domain.ports.in.CurrencyService;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(CurrencyController.CURRENCY)
public class CurrencyController {

	public static final String CURRENCY = "/currencies";
	public static final String ID = "/{id}";
	
	@Autowired
	private CurrencyService currencyService;
	
	@PostMapping
	public ResponseEntity<CurrencyDto> save(@RequestBody CurrencyDto currencyDto) {
		if (currencyDto.getId() != null || currencyDto.isEnabled() == false) {
			throw new BadRequestException(currencyDto.toString());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.save(currencyDto));
	}
	
	@PutMapping
	public ResponseEntity<CurrencyDto> update(@RequestBody CurrencyDto currencyDto) {
		if (currencyDto.getId() == null) throw new BadRequestException(currencyDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(currencyService.update(currencyDto));
	}
	
	@GetMapping()
	public ResponseEntity<Iterable<CurrencyDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(currencyService.findAll());
	}
	
	@GetMapping(ID)
	public ResponseEntity<CurrencyDto> findById(@PathVariable UUID id) {
		CurrencyDto currency = currencyService.findById(id);
		if (currency == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(currency);
	}
	
	@DeleteMapping(ID)
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		currencyService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

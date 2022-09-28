package ar.latorraca.finance.adapters.primary.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.TransactionDto;

@RestController
@RequestMapping(TransactionController.TRANSACTIONS)
public class TransactionController {

	protected static final String TRANSACTIONS = "/transactions";
	private static final String ID = "/{id}";

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody TransactionDto transactionDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionDto);
	}

}

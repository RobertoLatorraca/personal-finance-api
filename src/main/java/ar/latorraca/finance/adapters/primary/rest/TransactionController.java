package ar.latorraca.finance.adapters.primary.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.TransactionDto;
import ar.latorraca.finance.domain.models.transaction.Transaction;
import ar.latorraca.finance.domain.ports.in.transaction.TransactionService;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(TransactionController.TRANSACTIONS)
public class TransactionController {

	protected static final String TRANSACTIONS = "/transactions";

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	public ResponseEntity<TransactionDto> create(@RequestBody @Valid TransactionDto transactionDto) {
		if (transactionDto.getId() != null)
			throw new BadRequestException(transactionDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ModelMapperFacade.map(
						transactionService.save(ModelMapperFacade.map(transactionDto, Transaction.class)),
						TransactionDto.class));
	}

}

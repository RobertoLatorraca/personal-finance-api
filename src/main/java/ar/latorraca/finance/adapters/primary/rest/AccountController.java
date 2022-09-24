package ar.latorraca.finance.adapters.primary.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.AccountDto;
import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.ports.in.account.AccountService;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@RestController
@RequestMapping(AccountController.ACCOUNTS)
public class AccountController {

	protected static final String ACCOUNTS = "/accounts";

	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody AccountDto accountDto) {
		Account account = accountService.save(
				ModelMapperFacade.map(accountDto, accountDto.getAccountType().getClazz()));
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ModelMapperFacade.map(account, AccountDto.class));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		// TODO Convert to AccountDto.class
		return ResponseEntity.ok().body(accountService.findAll());
	}

}

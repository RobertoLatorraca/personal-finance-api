package ar.latorraca.finance.adapters.secondary.jpa.repositories.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

	Optional<CurrencyEntity> findByCurrencyOrCode(String currency, String code);
	
}

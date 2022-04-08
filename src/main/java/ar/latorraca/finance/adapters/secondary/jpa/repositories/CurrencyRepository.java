package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.CurrencyEntity;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, UUID> {

	Optional<CurrencyEntity> findByCurrencyOrCode(String currency, String code);
	
}

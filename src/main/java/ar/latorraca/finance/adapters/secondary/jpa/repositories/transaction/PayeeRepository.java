package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.PayeeEntity;

public interface PayeeRepository extends JpaRepository<PayeeEntity, String> {

	Optional<PayeeEntity> findByName(String name);

}

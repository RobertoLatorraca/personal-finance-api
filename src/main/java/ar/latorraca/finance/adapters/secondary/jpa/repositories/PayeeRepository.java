package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.PayeeEntity;

public interface PayeeRepository extends JpaRepository<PayeeEntity, UUID> {

	Optional<PayeeEntity> findByName(String name);

}

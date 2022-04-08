package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, UUID> {
	
	Optional<BankEntity> findByName(String Name);

}

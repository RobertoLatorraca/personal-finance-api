package ar.latorraca.finance.adapters.secondary.jpa.repositories.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, String> {
	
	Optional<BankEntity> findByName(String name);

}

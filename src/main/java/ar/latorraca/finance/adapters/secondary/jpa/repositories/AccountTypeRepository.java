package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.AccountTypeEntity;

public interface AccountTypeRepository extends JpaRepository<AccountTypeEntity, UUID> {

}

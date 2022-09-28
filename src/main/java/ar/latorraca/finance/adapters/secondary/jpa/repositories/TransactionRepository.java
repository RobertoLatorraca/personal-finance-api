package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

}

package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TransactionDetailEntity;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, UUID> {

}

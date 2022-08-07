package ar.latorraca.finance.adapters.secondary.jpa.repositories.account;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.account.BalanceEntity;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, UUID>{

}

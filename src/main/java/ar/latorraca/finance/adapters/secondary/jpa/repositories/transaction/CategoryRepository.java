package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

	Optional<CategoryEntity> findByName(String name);

}

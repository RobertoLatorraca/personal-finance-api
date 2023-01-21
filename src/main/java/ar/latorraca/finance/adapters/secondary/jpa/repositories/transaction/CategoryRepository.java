package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

	Optional<CategoryEntity> findByName(String name);

}

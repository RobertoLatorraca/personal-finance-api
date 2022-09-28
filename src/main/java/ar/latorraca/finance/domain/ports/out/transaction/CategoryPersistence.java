package ar.latorraca.finance.domain.ports.out.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.transaction.Category;

public interface CategoryPersistence {

	Category save(Category category);

	Optional<Category> findByName(String name);

	List<Category> findAll(Sort sort);

	Optional<Category> findById(UUID id);

}

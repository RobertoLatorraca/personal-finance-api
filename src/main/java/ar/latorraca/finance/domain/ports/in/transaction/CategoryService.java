package ar.latorraca.finance.domain.ports.in.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryGroup;

public interface CategoryService {

	Category save(Category category);

	List<Category> findAll();

	Optional<Category> findById(UUID id);

	Category update(UUID id, Category category);

	List<CategoryGroup> findCategoryGroups();

}

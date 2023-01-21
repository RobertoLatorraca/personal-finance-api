package ar.latorraca.finance.domain.ports.in.transaction;

import java.util.List;
import java.util.Optional;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryGroup;

public interface CategoryService {

	Category save(Category category);

	List<Category> findAll();

	Optional<Category> findById(String id);

	Category update(String id, Category category);

	List<CategoryGroup> findCategoryGroups();

}

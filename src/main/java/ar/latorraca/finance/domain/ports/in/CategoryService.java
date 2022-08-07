package ar.latorraca.finance.domain.ports.in;

import java.util.List;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryType;

public interface CategoryService {

	Category save(Category category);

	List<Category> findAll();

	List<CategoryType> findAllCategoriesType();

}

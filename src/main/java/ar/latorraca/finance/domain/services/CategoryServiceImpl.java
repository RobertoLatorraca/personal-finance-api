package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryType;
import ar.latorraca.finance.domain.ports.in.CategoryService;
import ar.latorraca.finance.domain.ports.out.transaction.CategoryPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryPersistence categoryPersistence;

	@Override
	public Category save(Category category) {
		if (category.getName() == null || category.getName().equals(""))
			throw new BadRequestException("Category name must not be empty.");
		if (category.getCategoryType() == null)
			throw new BadRequestException("Category type must not be null.");
		if (categoryPersistence.findByName(category.getName()).isPresent()) 
			throw new FieldAlreadyExistException(category.getName());
		return categoryPersistence.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryPersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public List<CategoryType> findAllCategoriesType() {
		return Stream.of(CategoryType.values())
//				.map(c -> c.name())
				.toList();
	}

}

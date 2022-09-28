package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.ports.in.transaction.CategoryService;
import ar.latorraca.finance.domain.ports.out.transaction.CategoryPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final int TRUE = 0;

	@Autowired
	private CategoryPersistence categoryPersistence;

	@Override
	public Category save(Category category) {
		if (category.getName() == null || category.getName().equals(""))
			throw new BadRequestException("Category name must not be empty.");
		if (categoryPersistence.findByName(category.getName()).isPresent()) 
			throw new FieldAlreadyExistException(category.getName());
		return categoryPersistence.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryPersistence.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Optional<Category> findById(UUID id) {
		return categoryPersistence.findById(id);
	}

	@Override
	public Category update(UUID id, Category category) {
		if (categoryPersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Category> categoryTestForDuplicates = categoryPersistence.findByName(category.getName());
		if (categoryTestForDuplicates.isPresent() && categoryTestForDuplicates.get().getId().compareTo(category.getId()) != TRUE)
				throw new FieldAlreadyExistException(category.getName());
		category.setId(id);
		return categoryPersistence.save(category);
	}

}

package ar.latorraca.finance.adapters.secondary.jpa.persistences.transaction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.CategoryEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction.CategoryRepository;
import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.ports.out.transaction.CategoryPersistence;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@Service
public class CategoryPersistenceImpl implements CategoryPersistence {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return ModelMapperFacade.map(
				categoryRepository.save(ModelMapperFacade.map(category, CategoryEntity.class)),
				Category.class);
	}

	@Override
	public Optional<Category> findByName(String name) {
		return categoryRepository.findByName(name)
				.map(c -> ModelMapperFacade.map(c, Category.class));
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort).stream()
				.map(c -> ModelMapperFacade.map(c, Category.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Category> findById(String id) {
		return categoryRepository.findById(id)
				.map(c -> ModelMapperFacade.map(c, Category.class));
	}

}

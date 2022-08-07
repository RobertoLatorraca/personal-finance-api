package ar.latorraca.finance.adapters.primary.rest;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.CategoryDto;
import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.ports.in.CategoryService;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(CategoryController.CATEGORIES)
public class CategoryController {

	protected static final String CATEGORIES = "/categories";
	private static final String TYPES = "/types";

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto) {
		if (categoryDto.getId() != null || categoryDto.isEnabled() == false)
			throw new BadRequestException(categoryDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ModelMapperFacade.map(
						categoryService.save(ModelMapperFacade.map(categoryDto, Category.class)),
						CategoryDto.class));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				categoryService.findAll().stream().map(
						c -> ModelMapperFacade.map(c, CategoryDto.class))
				.collect(Collectors.toList()));
	}

	@GetMapping(TYPES)
	public ResponseEntity<?> findAllCategoriesType() {
		return ResponseEntity.status(HttpStatus.OK).body(
				categoryService.findAllCategoriesType());
	}

}

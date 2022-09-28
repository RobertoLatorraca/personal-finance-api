package ar.latorraca.finance.adapters.primary.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.CategoryDto;
import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.ports.in.transaction.CategoryService;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(CategoryController.CATEGORIES)
public class CategoryController {

	protected static final String CATEGORIES = "/categories";
	private static final String ID = "/{id}";

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
		if (categoryDto.getId() != null || categoryDto.isEnabled() == false)
			throw new BadRequestException(categoryDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ModelMapperFacade.map(
						categoryService.save(ModelMapperFacade.map(categoryDto, Category.class)),
						CategoryDto.class));
	}

	@PutMapping(ID)
	public ResponseEntity<CategoryDto> update(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) {
		Category category = new ModelMapper().map(categoryDto, Category.class);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ModelMapper().map(categoryService.update(id, category), CategoryDto.class));
	}

	@GetMapping()
	public ResponseEntity<List<CategoryDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				categoryService.findAll().stream().map(
						c -> ModelMapperFacade.map(c, CategoryDto.class))
				.collect(Collectors.toList()));
	}

	@GetMapping(ID)
	public ResponseEntity<CategoryDto> findById(@PathVariable UUID id) {
		Optional<Category> result = categoryService.findById(id);
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new ModelMapper().map(result.get(), CategoryDto.class));
	}

}

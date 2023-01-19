package ar.latorraca.finance.adapters.primary.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.domain.models.transaction.CategoryGroup;
import ar.latorraca.finance.domain.ports.in.transaction.CategoryService;

@RestController
@RequestMapping(CategoryGroupController.GROUPS)
public class CategoryGroupController {

	protected static final String GROUPS = "/category-groups";

	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public ResponseEntity<List<CategoryGroup>> findCategoryGroups() {
		return ResponseEntity.ok(categoryService.findCategoryGroups());
	}

}

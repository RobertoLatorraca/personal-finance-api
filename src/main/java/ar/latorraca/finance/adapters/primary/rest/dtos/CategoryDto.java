package ar.latorraca.finance.adapters.primary.rest.dtos;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoryDto {

	private String id;
	private String name;
	private Category parentCategory;
	private String description;
	private CategoryGroup categoryGroup;
	private boolean enabled = true;

}

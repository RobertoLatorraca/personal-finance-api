package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.UUID;

import ar.latorraca.finance.domain.models.transaction.Category;
import ar.latorraca.finance.domain.models.transaction.CategoryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoryDto {

	private UUID id;
	private String name;
	private CategoryType categoryType;
	private Category parentCategory;
	private String description;
	private boolean enabled = true;

}

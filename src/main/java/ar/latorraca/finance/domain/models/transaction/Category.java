package ar.latorraca.finance.domain.models.transaction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

	private String id;
	private String name;
	private Category parentCategory;
	private String description;
	private CategoryGroup categoryGroup;
	private boolean enabled = true;

}

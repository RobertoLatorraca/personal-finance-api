package ar.latorraca.finance.domain.models.transaction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

	private String id;
	private String name;
	private CategoryType categoryType;
	private Category parentCategory;
	private String description;
	private boolean enabled = true;

}

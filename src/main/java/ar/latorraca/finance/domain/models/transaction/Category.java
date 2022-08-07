package ar.latorraca.finance.domain.models.transaction;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

	private UUID id;
	private String name;
	private CategoryType categoryType;
	private Category parentCategory;
	private String description;
	private boolean enabled = true;

}

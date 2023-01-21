package ar.latorraca.finance.adapters.primary.rest.dtos;

import ar.latorraca.finance.domain.models.transaction.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TagDto {

	private String id;
	private String tag;
	private Tag parentTag;
	private boolean enabled = true;
	
}

package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.UUID;

import ar.latorraca.finance.domain.models.transaction.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TagDto {

	private UUID id;
	private String tag;
	private Tag parentTag;
	private boolean enabled = true;
	
}

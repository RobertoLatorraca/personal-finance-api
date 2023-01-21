package ar.latorraca.finance.domain.models.transaction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tag {

	private String id;
	private String tag;
	private Tag parentTag;
	private boolean enabled = true;
	
}

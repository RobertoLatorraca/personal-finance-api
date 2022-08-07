package ar.latorraca.finance.domain.models.transaction;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tag {

	private UUID id;
	private String tag;
	private Tag parentTag;
	private boolean enabled = true;
	
}

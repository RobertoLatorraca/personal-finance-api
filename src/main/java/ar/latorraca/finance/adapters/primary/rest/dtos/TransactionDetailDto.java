package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDetailDto {

	private UUID id;
	private CategoryDto category;
	private TagDto tag;
	private String memo;
	private Double amount;

}

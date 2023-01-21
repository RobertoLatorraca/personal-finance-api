package ar.latorraca.finance.adapters.primary.rest.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDetailDto {

	private UUID id;

	@NotNull
	private CategoryDto category;

	private TagDto tag;

	@NotNull
	private String memo;

	@NotNull
	private Double amount;

}

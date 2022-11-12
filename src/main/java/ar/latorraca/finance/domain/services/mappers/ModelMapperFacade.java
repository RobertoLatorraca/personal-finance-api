package ar.latorraca.finance.domain.services.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import ar.latorraca.finance.adapters.primary.rest.dtos.AccountDto;
import ar.latorraca.finance.adapters.primary.rest.dtos.BalanceDto;
import ar.latorraca.finance.domain.models.account.Account;
import ar.latorraca.finance.domain.models.account.Balance;
import ar.latorraca.finance.domain.models.account.BankAccount;

public interface ModelMapperFacade {

	public static  <S, T> T map(S source, Class<T> destinationType) {
		return new ModelMapper().map(source, destinationType);
	}

	public static  <S, T> T map(S source, Class<T> destinationType, List<String> skipFields) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(new Condition<>() {
			@Override
			public boolean applies(MappingContext<Object, Object> context) {
				return !skipFields.stream()
						.anyMatch(f -> context.getMapping().getLastDestinationProperty().getName().equals(f));
			}
		});
		return modelMapper.map(source, destinationType);
	}

	public static <S, D> D patchObject(S source, D destination) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(source, destination);
		return destination;
	}

	public static <S, D> Set<D> mapSet(Set<S> source, Class<D> destinationType) {
		ModelMapper modelMapper = new ModelMapper();
		return source
				.stream()
				.map(e -> modelMapper.map(e, destinationType))
				.collect(Collectors.toSet());
	}

	public static <T extends Account> AccountDto mapAccountToDto(T account) {
		ModelMapper modelMapper = new ModelMapper();
		if (account instanceof BankAccount) {
			Converter<Balance, Set<BalanceDto>> toSetBalanceDto = new AbstractConverter<Balance, Set<BalanceDto>>() {
					@Override
					protected Set<BalanceDto> convert(Balance source) {
						return Set.of(map(source, BalanceDto.class));
					}
				};
			modelMapper.addConverter(toSetBalanceDto);
		}
		return modelMapper.map(account, AccountDto.class);
	}

}

package ar.latorraca.finance.domain.services.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

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
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		mapper.map(source, destination);
		return destination;
	}

	public static <S, D> Set<D> mapSet(Set<S> source, Class<D> destinationType) {
		ModelMapper modelMapper = new ModelMapper();
		return source
				.stream()
				.map(e -> modelMapper.map(e, destinationType))
				.collect(Collectors.toSet());
	}

}

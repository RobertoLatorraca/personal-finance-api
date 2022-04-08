package ar.latorraca.finance.adapters.secondary.jpa.persistences;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.CurrencyEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.CurrencyRepository;
import ar.latorraca.finance.domain.models.Currency;
import ar.latorraca.finance.domain.ports.out.CurrencyPersistence;

@Service
public class CurrencyPersistenceImpl implements CurrencyPersistence {
	
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Currency save(Currency currency) {
		CurrencyEntity currencyEntity = new ModelMapper().map(currency, CurrencyEntity.class);
		return new ModelMapper().map(currencyRepository.save(currencyEntity), Currency.class);
	}

	@Override
	public List<Currency> findAll(Sort sort) {
		List<Currency> result = new ArrayList<>();
		currencyRepository.findAll(sort).forEach(currencyEntity ->
				result.add(new ModelMapper().map(currencyEntity, Currency.class)));
		return result;
	}

	@Override
	public Optional<Currency> findById(UUID id) {
		Optional<CurrencyEntity> currencyEntity = currencyRepository.findById(id);
		if (currencyEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(currencyEntity.get(), Currency.class));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void deleteById(UUID id) {
		currencyRepository.deleteById(id);		

	}

	@Override
	public Optional<Currency> findByCurrencyOrCode(String currency, String code) {
		Optional<CurrencyEntity> currencyEntity = currencyRepository.findByCurrencyOrCode(currency, code);
		if (currencyEntity.isPresent()) {
			return Optional.of(new ModelMapper().map(currencyEntity.get(), Currency.class));
		} else {
			return Optional.empty();
		}
	}

}

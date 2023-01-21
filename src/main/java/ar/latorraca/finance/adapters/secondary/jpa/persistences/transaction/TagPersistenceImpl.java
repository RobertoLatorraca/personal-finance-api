package ar.latorraca.finance.adapters.secondary.jpa.persistences.transaction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TagEntity;
import ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction.TagRepository;
import ar.latorraca.finance.domain.models.transaction.Tag;
import ar.latorraca.finance.domain.ports.out.transaction.TagPersistence;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;

@Service
public class TagPersistenceImpl implements TagPersistence {

	@Autowired
	private TagRepository tagRepository;

	@Override
	public Tag save(Tag tag) {
		return ModelMapperFacade.map(
				tagRepository.save(ModelMapperFacade.map(tag, TagEntity.class)),
				Tag.class);
	}

	@Override
	public List<Tag> findAll(Sort sort) {
		return tagRepository.findAll(sort).stream()
				.map(e -> ModelMapperFacade.map(e, Tag.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Tag> findById(String id) {
		return tagRepository.findById(id)
				.map(e -> ModelMapperFacade.map(e, Tag.class));
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Tag> findByTag(String tag) {
		return tagRepository.findByTag(tag).map(e ->
				ModelMapperFacade.map(e, Tag.class));
	}

}

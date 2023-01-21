package ar.latorraca.finance.domain.ports.out.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import ar.latorraca.finance.domain.models.transaction.Tag;

public interface TagPersistence {

	Tag save(Tag tag);
	
	Optional<Tag> findByTag(String tag);

	List<Tag> findAll(Sort sort);

	Optional<Tag> findById(String id);

	void deleteById(String id);

}

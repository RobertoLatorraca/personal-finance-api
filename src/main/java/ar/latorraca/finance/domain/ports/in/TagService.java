package ar.latorraca.finance.domain.ports.in;

import java.util.List;
import java.util.Optional;

import ar.latorraca.finance.domain.models.transaction.Tag;

public interface TagService {

	Tag save(Tag tag);

	List<Tag> findAll();

	Optional<Tag> findById(String id);

	Tag update(String id, Tag tag);

}

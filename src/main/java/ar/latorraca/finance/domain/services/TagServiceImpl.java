package ar.latorraca.finance.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ar.latorraca.finance.domain.models.transaction.Tag;
import ar.latorraca.finance.domain.ports.in.TagService;
import ar.latorraca.finance.domain.ports.out.transaction.TagPersistence;
import ar.latorraca.finance.exception.errors.BadRequestException;
import ar.latorraca.finance.exception.errors.FieldAlreadyExistException;
import ar.latorraca.finance.exception.errors.NotFoundException;

@Service
public class TagServiceImpl implements TagService {

	private final int TRUE = 0;

	@Autowired
	private TagPersistence tagPersistence;

	@Override
	public Tag save(Tag tag) {
		if (tag.getTag() == null || tag.getTag().equals(""))
			throw new BadRequestException("Tag name must not be empty.");
		if (tagPersistence.findByTag(tag.getTag()).isPresent()) 
			throw new FieldAlreadyExistException(tag.getTag());
		return tagPersistence.save(tag);
	}

	@Override
	public List<Tag> findAll() {
		return tagPersistence.findAll(Sort.by(Direction.ASC, "tag"));
	}

	@Override
	public Optional<Tag> findById(String id) {
		return tagPersistence.findById(id);
	}

	@Override
	public Tag update(String id, Tag tag) {
		if (tag.getParentTag() != null && tag.getParentTag().isEnabled() == false)
				throw new BadRequestException("A parent Tag diabled is not allowed.");
		if (tagPersistence.findById(id).isEmpty()) throw new NotFoundException();
		Optional<Tag> tagTestForDuplicates = tagPersistence.findByTag(tag.getTag());
		if (tagTestForDuplicates.isPresent() && tagTestForDuplicates.get().getId().compareTo(tag.getId()) != TRUE)
				throw new FieldAlreadyExistException(tag.getTag());
		tag.setId(id);
		return tagPersistence.save(tag);
	}

}

package ar.latorraca.finance.adapters.primary.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.latorraca.finance.adapters.primary.rest.dtos.TagDto;
import ar.latorraca.finance.domain.models.transaction.Tag;
import ar.latorraca.finance.domain.ports.in.transaction.TagService;
import ar.latorraca.finance.domain.services.mappers.ModelMapperFacade;
import ar.latorraca.finance.exception.errors.BadRequestException;

@RestController
@RequestMapping(TagController.TAGS)
public class TagController {

	protected static final String TAGS = "/tags";
	private static final String ID = "/{id}";

	@Autowired
	private TagService tagService;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody TagDto tagDto) {
		if (tagDto.getId() != null || tagDto.isEnabled() == false)
			throw new BadRequestException(tagDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ModelMapperFacade.map(
						tagService.save(ModelMapperFacade.map(tagDto, Tag.class)),
						TagDto.class));
	}

	@GetMapping()
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				tagService.findAll().stream().map(
						t -> ModelMapperFacade.map(t, TagDto.class))
				.collect(Collectors.toList()));
	}

	@GetMapping(ID)
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Optional<Tag> result = tagService.findById(id);
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ModelMapperFacade.map(result.get(), TagDto.class));
	}

	@PutMapping(ID)
	public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody TagDto tagDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(ModelMapperFacade.map(
						tagService.update(id, ModelMapperFacade.map(tagDto, Tag.class)),
						TagDto.class));
	}

}

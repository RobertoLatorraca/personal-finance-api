package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, String> {

	Optional<TagEntity> findByTag(String tag);

}

package ar.latorraca.finance.adapters.secondary.jpa.repositories.transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.transaction.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {

	Optional<TagEntity> findByTag(String tag);

}

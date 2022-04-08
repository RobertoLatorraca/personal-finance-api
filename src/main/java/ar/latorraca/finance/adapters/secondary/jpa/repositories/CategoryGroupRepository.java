package ar.latorraca.finance.adapters.secondary.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.latorraca.finance.adapters.secondary.jpa.entities.CategoryGroupEntity;

public interface CategoryGroupRepository extends JpaRepository<CategoryGroupEntity, UUID> {

}

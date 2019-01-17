package com.dminers.pharmabi.external.repositories;

import com.dminers.pharmabi.external.domain.Drug;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface DrugRepository extends Neo4jRepository<Drug, String> {
    Optional<Drug> findFirstById(Long id);

    default void deleteById(Long id) {
        findFirstById(id).ifPresent(this::delete);
    }
}

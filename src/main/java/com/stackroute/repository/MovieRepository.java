package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}

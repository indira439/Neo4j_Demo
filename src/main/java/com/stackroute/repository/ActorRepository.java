package com.stackroute.repository;

import com.stackroute.domain.Actor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
    @Query("MATCH (c:Actor)<-[r:ACTED]-(m:Movie) RETURN c,r,m")
    Collection<Actor> getAllActor();
    @Query("CREATE(m:Movies)-[:ACTED {role: {role}]->(c:Actor)")
    Actor setRelation(@Param("role") String role);
}

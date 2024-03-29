package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @NodeEntity to indicate that this class is directly mapped to a node in Neo4j.
 */
@NodeEntity

/**With @Data, Lombok will generate getter and setter methods, toString methods, Equal & Hashcode methods*/
@Data

/**@NoArgsConstructor will add constructor with no arguments*/
@NoArgsConstructor

/**@AllArgsConstructor will add constructor with all properties in the class*/
@AllArgsConstructor

public class Actor {

    /**
     * @Id annotation make id variable as Primary key
     */
    @Id
    private long id;
    private String name;
    private int age;

    /**
     * @Relationship is used to map the relationship between the nodes
     */
    @Relationship(type = "ACTOR", direction = Relationship.INCOMING)
    private List<Movie> movies;

}

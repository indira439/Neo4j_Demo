package com.stackroute.controller;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import com.stackroute.exceptions.AlreadyExistsException;
import com.stackroute.service.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "api/v1")
public class ActorController {
    private MovieActorService movieActorService;

    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */

    @Autowired
    private ActorController(MovieActorService movieActorService) {
        this.movieActorService = movieActorService;
    }


    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping(value = "/actor")
    public Actor saveActor(@RequestBody Actor actor) throws Exception {
        return movieActorService.saveActor(actor);
    }

    @PostMapping(value = "/movie")
    public Movie saveMovie(@RequestBody Movie movie) throws Exception {
        return movieActorService.saveMovie(movie);
    }


    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping(value = "/actors")
    public Collection<Actor> getAllActor() throws Exception {
        return movieActorService.getAllActors();
    }

    @GetMapping(value = "/movies")
    public Iterable<Movie> getAllMovie() throws Exception {
        return movieActorService.getAllMovies();
    }


    /**
     * DeleteMapping Annotation for mapping HTTP DELETE requests onto specific handler methods.
     */
    @DeleteMapping(value = "/movie/{id}")
    public Optional<Movie> deleteMovieById(@PathVariable int id) throws Exception {
        return movieActorService.deleteMovieById(id);
    }

    @DeleteMapping(value = "/actor")
    public boolean deleteAllActors(@RequestBody Actor actor) throws Exception {
        return movieActorService.deleteAllActors();
    }


    @PostMapping(value = "/critic/set")
    public Actor setRelation(@RequestParam long actorId, long movieId, String role) {
        return movieActorService.setRelation(actorId, movieId, role);
    }


}

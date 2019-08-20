package com.stackroute.controller;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import com.stackroute.service.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/v1")
public class ActorController {
    private MovieActorService movieActorService;

    @Autowired
    private ActorController(MovieActorService movieActorService) {
        this.movieActorService = movieActorService;
    }

    @GetMapping(value = "/actors")
    public Collection<Actor> getAllActor() {
        return movieActorService.getAllActor();
    }

    @GetMapping(value = "/movies")
    public Iterable<Movie> getAllMovie() {
        return movieActorService.getAllMovie();
    }

    @PostMapping(value = "/actor")
    public Actor saveActor(@RequestBody Actor actor) {
        System.out.println("****" + actor);
        return movieActorService.saveActor(actor);
    }

    @PutMapping(value = "/actor")
    public Actor updateActor(@RequestBody Actor actor) {
        System.out.println("****" + actor);
        return movieActorService.updateActorById(actor);
    }

    @PostMapping(value = "/movie")
    public Movie saveMovie(@RequestBody Movie movie) {
        System.out.println("****" + movie);
        return movieActorService.saveMovie(movie);
    }

    @PutMapping(value = "/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        System.out.println("****" + movie);
        return movieActorService.updateMovieById(movie);
    }

    @DeleteMapping(value = "/critic")
    public Actor deleteActor(@RequestBody Actor actor) {
        System.out.println("****" + actor);
        return movieActorService.deleteActorById(actor);
    }

    @DeleteMapping(value = "/movie")
    public Movie deleteMovie(@RequestBody Movie movie) {
        System.out.println("****" + movie);
        return movieActorService.deleteMovieById(movie);
    }

    @PostMapping(value = "/critic/set")
    public Actor setRelation(@RequestParam long actorId, long movieId, String role) {
        return movieActorService.setRelation(actorId, movieId, role);
    }


}

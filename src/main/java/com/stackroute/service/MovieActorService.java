package com.stackroute.service;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;

import java.util.Collection;

public interface MovieActorService {
    Actor getActorById(Actor actor);

    Actor saveActor(Actor movie);

    Collection<Actor> getAllActor();

    Actor deleteActorById(Actor actor);

    Actor updateActorById(Actor movie);

    Movie getMovieById(Movie movie);

    Movie saveMovie(Movie movie);

    Iterable<Movie> getAllMovie();

    Movie deleteMovieById(Movie movie);

    Movie updateMovieById(Movie movie);

    Actor setRelation(long actorId, long movieId, String role);
}


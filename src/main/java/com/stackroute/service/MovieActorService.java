package com.stackroute.service;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import com.stackroute.exceptions.AlreadyExistsException;
import com.stackroute.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface MovieActorService {
    public Movie saveMovie(Movie movie) throws AlreadyExistsException;

    public List<Movie> getAllMovies() throws Exception;

    public Movie getMovieById(long id) throws NotFoundException;

    public Optional<Movie> deleteMovieById(long id) throws NotFoundException;

    public boolean deleteAllMovies() throws Exception;

    public Actor saveActor(Actor actor) throws AlreadyExistsException;

    public List<Actor> getAllActors() throws Exception;

    public Actor getActorById(long id) throws NotFoundException;

    public boolean deleteAllActors() throws Exception;

    public Actor setRelation(long actorId, long movieId, String role);
}



package com.stackroute.service;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import com.stackroute.exceptions.AlreadyExistsException;
import com.stackroute.exceptions.NotFoundException;
import com.stackroute.repository.ActorRepository;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class MovieActorServiceImpl implements MovieActorService {

    private ActorRepository actorRepository;
    private MovieRepository movieRepository;

    /**
     * Constructor based Dependency injection to inject MovieRepository/Actor Repository here
     */
    @Autowired
    public MovieActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws AlreadyExistsException {
        /**Throw AlreadyExistsException if movie already exists*/
        if (movieRepository.existsById(movie.getId())) {
            throw new AlreadyExistsException();
        }
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;

    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) throws NotFoundException {
        /**Throws NotFoundException if movie we want to get is not found*/
        if (movieRepository.existsById(id)) {
            Movie retrieveMovieById = movieRepository.findById(id).get();
            return retrieveMovieById;
        } else {
            throw new NotFoundException("Movie you want to get is not found");
        }
    }

    @Override
    public Optional<Movie> deleteMovieById(long id) throws NotFoundException {
        /**Throws NotFoundException if movie we want to delete is not found*/
        if (movieRepository.existsById(id)) {
            Optional<Movie> deletedMovie = movieRepository.findById(id);
            movieRepository.deleteById(id);
            return deletedMovie;
        } else {
            throw new NotFoundException("Movie you want to delete is not found");
        }
    }

    @Override
    public boolean deleteAllMovies() throws Exception {
        /**Throws Exception if Database connection issue happens*/
        movieRepository.deleteAll();
        return true;
    }

    @Override
    public Actor saveActor(Actor actor) throws AlreadyExistsException {
        /**Throw AlreadyExistsException if movie already exists*/
        if (actorRepository.existsById(actor.getId())) {
            throw new AlreadyExistsException();
        }
        Actor savedActor = actorRepository.save(actor);
        return savedActor;
    }

    @Override
    public List<Actor> getAllActors() throws Exception {
        /**Throws Exception if Database connection issue happens*/
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public Actor getActorById(long id) throws NotFoundException {
        /**Throws NotFoundException if actor we want to get is not found*/
        if (actorRepository.existsById(id)) {
            Actor retrieveActorById = actorRepository.findById(id).get();
            return retrieveActorById;
        } else {
            throw new NotFoundException("Actor you want to get is not found");
        }
    }

    @Override
    public boolean deleteAllActors() throws Exception {
        /**Throws Exception if Database connection issue happens*/
        actorRepository.deleteAll();
        return true;
    }

    @Override
    public Actor setRelation(long actorId, long movieId, String role) {
        return actorRepository.setRelation(role);
    }

}

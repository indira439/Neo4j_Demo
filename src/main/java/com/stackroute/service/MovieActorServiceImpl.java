package com.stackroute.service;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import com.stackroute.repository.ActorRepository;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieActorServiceImpl implements MovieActorService {
    private ActorRepository actorRepository;
    private MovieRepository movieRepository;

    @Autowired
    public MovieActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Actor getActorById(Actor actor) {

        return actorRepository.findById(actor.getId()).get();
    }

    @Override
    public Actor saveActor(Actor actor) {
        System.out.println(actor);
        return actorRepository.save(actor);
    }

    @Override
    public Collection<Actor> getAllActor() {
        return actorRepository.getAllActor();
    }

    @Override
    public Actor deleteActorById(Actor actor) {
        Optional<Actor> optionalMovie = actorRepository.findById(actor.getId());
        actorRepository.deleteById(actor.getId());
        return optionalMovie.get();
    }

    @Override
    public Actor updateActorById(Actor actor) {
        actorRepository.deleteById(actor.getId());
        return actorRepository.save(actor);
    }

    @Override
    public Movie getMovieById(Movie movie) {

        return movieRepository.findById(movie.getId()).get();
    }

    @Override
    public Movie saveMovie(Movie movie) {

        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> getAllMovie() {

        return movieRepository.findAll();
    }

    @Override
    public Movie deleteMovieById(Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findById(movie.getId());
        movieRepository.deleteById(movie.getId());
        return optionalMovie.get();
    }

    @Override
    public Movie updateMovieById(Movie movie) {
        movieRepository.deleteById(movie.getId());
        return movieRepository.save(movie);
    }

    @Override
    public Actor setRelation(long actorId, long movieId, String role) {
        return actorRepository.setRelation(role);
    }

}

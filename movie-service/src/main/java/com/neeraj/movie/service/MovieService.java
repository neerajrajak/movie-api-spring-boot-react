package com.neeraj.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.movie.entity.Movie;
import com.neeraj.movie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	public List<Movie> findAllMovies() {
        return repository.findAll();
    }
	
	public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}

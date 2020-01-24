package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.persistence.entity.Movie;


public interface IMovieService {


	List<Movie> getAllMovies();	
	Optional<Movie> getMovieById(int id);
	Set<Movie> getMovieByPartialTitle (String partialTitle);
	Set<Movie> getByTitleAndYear(String title, int year);
	Set <Movie> getByActor(int idActor);
	Set<Movie> getByDirector(int idDirector);
	

	
	
}


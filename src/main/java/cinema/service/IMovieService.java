package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;


public interface IMovieService {


	List<Movie> getAllMovies();	
	Optional<Movie> getMovieById(int id);
	Set<Movie> getMovieByPartialTitle (String partialTitle);
	Set<Movie> getByTitleAndYear(String title, int year);
	Set <Movie> getByActor(int idActor);
	Set<Movie> getByDirector(int idDirector);
	Set<Movie> getByClassification(String classification);
	Set<Movie> getByColor(String color);
	Movie addMovie(Movie movie);

	Optional<Movie> deleteMovie(int id);
	Optional<Movie> setDirector(int idDirector, int idMovie);
	Optional<Movie> addActor(int idActor, int idMovie);
	Optional<Movie> modifyMovie(Movie movie);


}


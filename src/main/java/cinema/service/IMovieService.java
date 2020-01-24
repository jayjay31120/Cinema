package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;

public interface IMovieService {


	List<Movie> getAllMovies();	
	Optional<Movie> getMovieById(int id);
	Set<Movie> getMovieByPartialTitle (String partialTitle);
	Set<Movie> getByTitleAndYear(String title, int year);
	Set <Movie> getByActor(int idActor);
	Set<Movie> getByDirector(int idDirector);
	

	
	
}

package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;



public interface IMovieService {


	List<SimpleMovie> getAllMovies();	
	Optional<MovieFull> getMovieById(int id);
	Set<SimpleMovie> getMovieByPartialTitle (String partialTitle);
	Set<SimpleMovie> getByTitleAndYear(String title, int year);
	Set <SimpleMovie> getByActor(int idActor);
	Set<SimpleMovie> getByDirector(int idDirector);
	Set<SimpleMovie> getByClassification(String classification);
	Set<SimpleMovie> getByColor(String color);
	
	MovieFull addMovie(MovieFull movie);
	Optional<MovieFull> deleteMovie(int id);
	Optional<MovieFull> setDirector(int idDirector, int idMovie);
	Optional<MovieFull> addActor(int idActor, int idMovie);
	Optional<MovieFull> modifyMovie(MovieFull movie);


}


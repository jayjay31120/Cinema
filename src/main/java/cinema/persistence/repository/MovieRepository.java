package cinema.persistence.repository;

//import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	// extends JpaRepo permet d'avoir les methodes cadeaux deja inclues
//	void save(cinema.data.Movie m);	
	Set<Movie> findByTitle(String title);
	//find by Year
	Set<Movie> findByYear(int year);
	//find by year <= year2
	Set<Movie> findByYearLessThanEqual(int year);
	//find betweenYear
	Set<Movie> findByYearBetween(int year, int year_end);
	//find By Title and Year
	Set<Movie> findByTitleAndYear(String title, int year);

	Set<Movie>findByTitleContainingIgnoreCase(String title);
	
	Set<Movie>findByDirector(Person director);
	
	Set<Movie>findByDirectorNameEndingWith(String director);
	Set<Movie>findByActorsNameEndingWith(String actor);
	
//	Set<Movie>findByActor(Person actor);
	Set<Movie> findByActors(Person actor);
	Set<Movie> findByClassification(String classification);
	
	Set<Movie> findByColor(String color);
//	Set<Movie> addMovie(Movie movie);
	
	
	
	
	
}

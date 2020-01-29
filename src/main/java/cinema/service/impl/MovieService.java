package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;
import cinema.service.IMovieService;

@Service
@Transactional

public class MovieService implements IMovieService {
	
	@Autowired
	MovieRepository movieRepository;
	// !!!!!!!!!! attention !!!!!!!!
	@Autowired
	PersonRepository personRepository; 


	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int id) {
		return movieRepository.findById(id);
		
	}

	@Override
	public Set<Movie> getMovieByPartialTitle(String partialTitle) {
		return movieRepository.findByTitleContainingIgnoreCase(partialTitle);	}

	@Override
	public Set<Movie> getByTitleAndYear(String title, int year) {
		return movieRepository.findByTitleAndYear(title, year);
	}

	@Override
	public Set<Movie> getByActor(int idActor) {
		var actor = personRepository.findById(idActor);
		return actor.map(a-> movieRepository.findByActors(a)).orElseGet(()-> Collections.emptySet());
	}

	@Override
	public Set<Movie> getByDirector(int idDirector) {
		var director = personRepository.findById(idDirector);
		return director.map(d-> movieRepository.findByDirector(d)).orElseGet(()->Collections.emptySet());
	}
	

	@Override
	public Set<Movie> getByClassification(String classification) {
		Set<Movie> classif = movieRepository.findByClassification(classification);
	
	return  classif;
	}

	@Override
	public Set<Movie> getByColor(String color) {
		Set<Movie> color1 = movieRepository.findByColor(color);
			return color1;
	}

	@Override
	public Movie addMovie(Movie movie) {
		Movie movie1= movieRepository.save(movie);
		return movie1;
	}

	@Override
    public Optional<Movie> deleteMovie(int id) {
                var movieToDelete = movieRepository.findById(id);
                movieToDelete.ifPresent(m -> {
                    movieRepository.delete(m);
                    movieRepository.flush();
                });
                return movieToDelete;
    }
	
	@Override
	public Optional<Movie> addActor(int idActor, int idMovie)
	{
		var movieOpt = movieRepository.findById(idMovie);
		var actorOpt = personRepository.findById(idActor);
		if (movieOpt.isPresent() && actorOpt.isPresent()) {
			movieOpt.get().getActors().add(actorOpt.get());
		movieRepository.flush();
		}
		return movieOpt;
	}
	
	@Override
	public Optional<Movie> setDirector( int idDirector, int idMovie) 
	{
		var movie = movieRepository.findById(idMovie);
		var director = personRepository.findById(idDirector);
		if (movie.isPresent() && director.isPresent()) {		
		movie.get().setDirector(director.get());
		movieRepository.flush();
		}
		return movie;
	}

	@Override
	public Optional<Movie> modifyMovie( Movie movie)
	{
		var optMovie = movieRepository.findById(movie.getId());
		optMovie.ifPresent(m-> { 
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
			m.setDuration(movie.getDuration());
			m.setDirector(movie.getDirector());
		});
		movieRepository.flush();
		return optMovie;
	}
	
	
}

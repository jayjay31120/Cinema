package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;

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
	
	@Autowired
	ModelMapper mapper;


	@Override
	public List<SimpleMovie> getAllMovies() {
		List<Movie> movieEntities = movieRepository.findAll();
		return movieEntities.stream()
					.map(me -> mapper.map(me, SimpleMovie.class))
					.collect(Collectors.toList());
		
		
		//  code pour un seul film
		//var movieEntity = movieEntities.get(0);
		//var movieDto = mapper.map(movieEntity, SimpleMovie.class);
		//return List.of(movieDto);
	}

	@Override
	public Optional<MovieFull> getMovieById(int id) 
	{
		return movieRepository.findById(id)
				.map(me -> mapper.map(me, MovieFull.class));	
	}

	// Avant DTO
//	@Override
//	public MovieFull addMovie(MovieFull movie) {
//		Movie movie1= movieRepository.save(movie);
//		return movie1;
//	}
	
	// Après DTO
	@Override
    public MovieFull addMovie(MovieFull movie) {
        Movie movieSaved = mapper.map(movie, Movie.class);
        movieRepository.save(movieSaved);
        return movie;
    }
	
	@Override
	public Set<SimpleMovie> getMovieByPartialTitle(String partialTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SimpleMovie> getByTitleAndYear(String title, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SimpleMovie> getByActor(int idActor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SimpleMovie> getByDirector(int idDirector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SimpleMovie> getByClassification(String classification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SimpleMovie> getByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<MovieFull> deleteMovie(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> setDirector(int idDirector, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> addActor(int idActor, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> modifyMovie(MovieFull movie) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Set<SimpleMovie> getMovieByPartialTitle(String partialTitle) {
//		return movieRepository.findByTitleContainingIgnoreCase(partialTitle);	}
//
//	@Override
//	public Set<SimpleMovie> getByTitleAndYear(String title, int year) {
//		return movieRepository.findByTitleAndYear(title, year);
//	}
//
//	@Override
//	public Set<SimpleMovie> getByActor(int idActor) {
//		var actor = personRepository.findById(idActor);
//		return actor.map(a-> movieRepository.findByActors(a)).orElseGet(()-> Collections.emptySet());
//	}
//
//	@Override
//	public Set<SimpleMovie> getByDirector(int idDirector) {
//		var director = personRepository.findById(idDirector);
//		return director.map(d-> movieRepository.findByDirector(d)).orElseGet(()->Collections.emptySet());
//	}
//	
//
//	@Override
//	public Set<SimpleMovie> getByClassification(String classification) {
//		Set<Movie> classif = movieRepository.findByClassification(classification);
//	
//	return  classif;
//	}
//
//	@Override
//	public Set<SimpleMovie> getByColor(String color) {
//		Set<Movie> color1 = movieRepository.findByColor(color);
//			return color1;
//	}
//

//
//	@Override
//    public Optional<MovieFull> deleteMovie(int id) {
//                var movieToDelete = movieRepository.findById(id);
//                movieToDelete.ifPresent(m -> {
//                    movieRepository.delete(m);
//                    movieRepository.flush();
//                });
//                return movieToDelete;
//    }
//	
//	@Override
//	public Optional<MovieFull> addActor(int idActor, int idMovie)
//	{
//		var movieOpt = movieRepository.findById(idMovie);
//		var actorOpt = personRepository.findById(idActor);
//		if (movieOpt.isPresent() && actorOpt.isPresent()) {
//			movieOpt.get().getActors().add(actorOpt.get());
//		movieRepository.flush();
//		}
//		return movieOpt;
//	}
//	
//	@Override
//	public Optional<MovieFull> setDirector( int idDirector, int idMovie) 
//	{
//		var movie = movieRepository.findById(idMovie);
//		var director = personRepository.findById(idDirector);
//		if (movie.isPresent() && director.isPresent()) {		
//		movie.get().setDirector(director.get());
//		movieRepository.flush();
//		}
//		return movie;
//	}
//
//	@Override
//	public Optional<MovieFull> modifyMovie( MovieFull movie)
//	{
//		var optMovie = movieRepository.findById(movie.getId());
//		optMovie.ifPresent(m-> { 
//			m.setTitle(movie.getTitle());
//			m.setYear(movie.getYear());
//			m.setDuration(movie.getDuration());
//			m.setDirector(movie.getDirector());
//		});
//		movieRepository.flush();
//		return optMovie;
//	}
	
	
}

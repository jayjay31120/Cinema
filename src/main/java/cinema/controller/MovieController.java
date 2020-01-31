package cinema.controller;

//import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;

import cinema.persistence.entity.Person;

@RestController
@RequestMapping("/api/movies")

public class MovieController {

	@Autowired
	cinema.service.IMovieService movieService;

	@GetMapping
	@ResponseBody
	public List<SimpleMovie> AllMovies() 
	{
		return movieService.getAllMovies();
	} 


	@GetMapping("/{id}")
	@ResponseBody
	public Optional<MovieFull> movieById(@PathVariable("id") int idMovie) 
	{
		return movieService.getMovieById(idMovie);		
	}



	@GetMapping("/byTitle")
	@ResponseBody
	public Set<SimpleMovie> movieByPartiaTitle (@RequestParam("t") String partialTitle)
	{
		return movieService.getMovieByPartialTitle(partialTitle); 
	}


	@GetMapping("/byTitleAndYear")
	@ResponseBody
	Set<SimpleMovie> findByTitleAndYear(@RequestParam("t") String title,@RequestParam("y") int year)
	{
		return movieService.getByTitleAndYear(title, year);
	}


	@GetMapping("/findByDirector")
	public Set<SimpleMovie> findByDirector(@RequestParam("d") int idDirector) 
	{
		return movieService.getByDirector(idDirector);
	}


	@GetMapping("/findByActor")
	public Set <SimpleMovie> findByActor(@RequestParam("a") int idActor) 
	{
		return movieService.getByActor(idActor);	
	}


	@GetMapping("/findByClassification")
	public Set<SimpleMovie> findByClassification(@RequestParam("c") String classification) 
	{
		return movieService.getByClassification(classification);	
	}


	@GetMapping("/findByColor")
	public Set<SimpleMovie> findByColor(@RequestParam("c") String color) 
	{
		return movieService.getByColor(color);	
	}


	@PostMapping
	@ResponseBody
	public MovieFull addMovie(@RequestBody MovieFull movie)
	{
		return movieService.addMovie(movie);
	}

	

	@DeleteMapping("/deleteMovie/{id}")
	@ResponseBody
	public Optional<MovieFull> deleteMovie(@PathVariable("id") int id) 
	{
		return movieService.deleteMovie(id);	
	}

	
	
	@PutMapping("/addActor")
	public Optional<MovieFull> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie)
	{
		return movieService.addActor(idActor, idMovie);
	}

	

	@PostMapping("/setDirector")
	public Optional<MovieFull> setDirector(@RequestParam("d") int idDirector, @RequestParam("m") int idMovie) 
	{		
		return movieService.setDirector(idDirector, idMovie);
	}


	@PutMapping("/modify")
	@ResponseBody
	public Optional<MovieFull> modifyMovie(@RequestBody MovieFull movie) 
	{
		return movieService.modifyMovie(movie);
	}









}
//	
//
//	
//	@PostMapping
//	@ResponseBody
//	public Movie addMovie(@RequestBody Movie movie) {
//		Movie moviesaved = movieRepository.save(movie);
//		movieRepository.flush();
//		return moviesaved;
//	}
//





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

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;

@RestController
@RequestMapping("/api/movies")

public class MovieController {

	@Autowired
	cinema.service.IMovieService movieService;

	@GetMapping
	@ResponseBody
	public List<Movie> AllMovies() 
	{
		return movieService.getAllMovies();
	}


	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Movie> movieById(@PathVariable("") int id) 
	{
		return movieService.getMovieById(id);		
	}
	
	

	@GetMapping("/byTitle")
	@ResponseBody
	public Set<Movie> movieByPartiaTitle (@RequestParam("t") String partialTitle)
	{
		return movieService.getMovieByPartialTitle(partialTitle); 
	}
	
	
	@GetMapping("/byTitleAndYear")
	@ResponseBody
	Set<Movie> findByTitleAndYear(@RequestParam("t") String title,@RequestParam("y") int year)
	{
		return movieService.getByTitleAndYear(title, year);
	}


	@GetMapping("/findByDirector")
	public Set<Movie> findByDirector(@RequestParam("d") int idDirector) 
	{
		return movieService.getByDirector(idDirector);
	}
		
		
	@GetMapping("/findByActor")
	public Set <Movie> findByActor(@RequestParam("a") int idActor) 
	{
		return movieService.getByActor(idActor);	
	}
	
	
	@GetMapping("/findByClassification")
	public Set<Movie> findByClassification(@RequestParam("c") String classification) 
	{
		return movieService.getByClassification(classification);	
	}
	
	
	@GetMapping("/findByColor")
	public Set<Movie> findByColor(@RequestParam("c") String color) 
	{
		return movieService.getByColor(color);	
	}
	
	
	@PostMapping
	@ResponseBody
	public Movie addMovie(@RequestBody Movie movie)
	{
		return movieService.addMovie(movie);
	}
	
	
	@DeleteMapping("/deleteMovie/{id}")
    @ResponseBody
    public Optional<Movie> deleteMovie(@PathVariable("id") int id) 
	{
        return movieService.deleteMovie(id);	
	}
	
	@PutMapping("/addActor")
	public Optional<Movie> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie)
	{
		return movieService.addActor(idActor, idMovie);
	}
	
		//	if (actor.isPresent()) {
		//		return movieRepository.findByActors(actor.get());
		//	}
		//	return Collections.emptySet() ;
	
		@PostMapping("/setDirector")
		public Optional<Movie> setDirector(@RequestParam("d") int idDirector, @RequestParam("m") int idMovie) 
		{		
			return movieService.setDirector(idDirector, idMovie);
		}
		

		@PutMapping("/modify")
		@ResponseBody
		public Optional<Movie> modifyMovie(@RequestBody Movie movie) 
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
	
	
	


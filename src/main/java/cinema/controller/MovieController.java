package cinema.controller;

//import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Movie;
import cinema.service.IMovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	IMovieService movieService;

	@GetMapping
	@ResponseBody
	public List<Movie> AllMovies() {
		return movieService.getAllMovies();
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Movie> movieById(@PathVariable("") int id) {
		return movieService.getMovieById(id);		
	}


	@GetMapping("/byTitle")
	@ResponseBody
	public Set<Movie> movieByPartiaTitle (@RequestParam("t") String partialTitle){
		return movieService.getMovieByPartialTitle(partialTitle); 
	}
	@GetMapping("/byTitleAndYear")
	@ResponseBody
	Set<Movie> findByTitleAndYear(@RequestParam("t") String title,@RequestParam("y") int year){
		return movieService.getByTitleAndYear(title, year);

	}

	
	

	@GetMapping("/findByDirector")
	public Set<Movie> findByDirector(@RequestParam("d") int idDirector) {
		return movieService.getByDirector(idDirector);
	}
	//	
	//	
	@GetMapping("/findByActor")
	public Set <Movie> findByActor(@RequestParam("a") int idActor) {
		return movieService.getByActor(idActor);
		//	if (actor.isPresent()) {
		//		return movieRepository.findByActors(actor.get());
		//	}
		//	return Collections.emptySet() ;
	}
	
	
	//	
	//	//	@PostMapping("/setDirector")
	//	public Optional<Movie> setDirector(@RequestParam("d") int idDirector, @RequestParam("m") int idMovie) {
	//	var movie = movieRepository.findById(idMovie);
	//	var director = personRepository.findById(idDirector);
	//	if (movie.isPresent() && director.isPresent()) {		
	//	movie.get().setDirector(director.get());
	//	movieRepository.flush();
	//	}
	//	return movie;
	//	
	//}
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
	//	@PutMapping("/addActor")
	//	public Optional<Movie> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie) {
	//		var movieOpt = movieRepository.findById(idMovie);
	//		var actorOpt = personRepository.findById(idActor);
	//		if (movieOpt.isPresent() && actorOpt.isPresent()) {
	//			movieOpt.get().getActors().add(actorOpt.get());
	//		movieRepository.flush();
	//		}
	//		return movieOpt;
	//		
	//	}
	//	
	//
	//	@PutMapping("/modify")
	//	@ResponseBody
	//	public Optional<Movie> modifyMovie(@RequestBody Movie movie) {
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
	//
	//	@DeleteMapping("/{id}")
	//	@ResponseBody
	//	public Optional<Movie> deleteMovie(@PathVariable("id") int id) {
	//		var movieToDelete = movieRepository.findById(id);
	//		movieToDelete.ifPresent(m -> {
	//			movieRepository.delete(m);
	//			movieRepository.flush();
	//		});
	//		return movieToDelete;


}

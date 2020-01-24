package cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import cinema.persistence.entity.Person;
import cinema.service.iPersonService;

public class PersonController {
	
	@Autowired
	iPersonService personService;
	

	@GetMapping
	@ResponseBody
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}

	
	@PostMapping("/addPerson")
	
	
	
	
	
	//	public Optional<Movie> setDirector(@RequestParam("d") int idDirector, @RequestParam("m") int idMovie) {
	//	var movie = movieRepository.findById(idMovie);
	//	var director = personRepository.findById(idDirector);
	//	if (movie.isPresent() && director.isPresent()) {		
	//	movie.get().setDirector(director.get());
	//	movieRepository.flush();
	//	}
	//	return movie;
	
	
	
	
	
	
	
	
	
	
//	@PostMapping
//	@ResponseBody
//	public Person addPerson(@RequestBody Person person) {
//		
//	}
//		public Movie addMovie(@RequestBody Movie movie) {
//			//		Movie moviesaved = movieRepository.save(movie);
//			//		movieRepository.flush();
//			//		return moviesaved;
//		//tofo
//		return null;
//	}


}

package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Person;
import cinema.service.IPersonService;
import cinema.service.impl.PersonService;



@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	IPersonService personService;

	@GetMapping
	@ResponseBody
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Person> getById (@PathVariable("id") int id){
		return personService.getById(id); 
	}

	@PostMapping
	@ResponseBody
	public Person addPerson(@RequestBody Person person){
		return personService.addPerson(person);
	}


	@DeleteMapping("/deletePerson/{id}")
	public Optional<Person> deletePerson(@PathVariable("id") int id){
		return personService.deletePerson(id);
	}


	@GetMapping("/searchPersonByPartialName")
	@ResponseBody
	public Set<Person> searchByPersonByPartialName(@RequestParam("n") String partialName){
		return personService.getByPartialName(partialName);

	}

	@GetMapping("/searchByNation")
	@ResponseBody
	public Set<Person> getByPartialNatio(@RequestParam("n") String partialName)
	{
		return personService.getByPartialNatio(partialName);
	}
	
	

}

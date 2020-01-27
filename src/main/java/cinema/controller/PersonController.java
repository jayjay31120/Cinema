//package cinema.controller;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import cinema.persistence.entity.Person;
//import cinema.service.IPersonService;
//
//@RestController
//@RequestMapping("/api/person")
//public class PersonController {
//
//	@Autowired
//	IPersonService personService;
//
//
//	@GetMapping
//	@ResponseBody
//	public List<Person> getAllPersons(){
//		return personService.getAllPersons();
//	}
//
//	@GetMapping("/{id}")
//	@ResponseBody
//	public Optional<Person> getById (@PathVariable("id") int id){
//		return personService.getById(id); 
//	}
//
//	@PostMapping
//	@ResponseBody
//	public Person addPerson(@RequestBody Person person){
//		return personService.addActor(person);
//	}
//
//
//	@DeleteMapping("/deletePerson/{id}")
//	public Set <Person> deleteActor(@PathVariable("id") int id){
//		return personService.deleteActor(id);
//	}
//
//
//	@GetMapping("/searchPersonByPartialName")
//	@ResponseBody
//	Set<Person> searchByPersonAndBirth(@RequestParam("n") String partialName){
//		return personService.getByTitleAndYear(partialName);
//
//	}
//	
//	
//
//
//}

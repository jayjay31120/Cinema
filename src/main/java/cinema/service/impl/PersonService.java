package cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;



@Service
@Transactional
public class PersonService implements cinema.controller.IPersonService{

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
	@Override
	public Optional<Person> getById(int id) {
		var person = personRepository.findById(id);
		if (person.isPresent()) {
			return person;}
		return null; 
			
		}

	@Override
	public Person addPerson(Person person) {
		Person person1 = personRepository.save(person);
		return person1;
	}
	@Override
	public Optional<Person> deleteActor(int id) {
		// TODO Auto-generated method stub
		return null;
	}



//	@Override
//	public Optional <Person> deleteActor(int id) {
//		var person1 =  personRepository.findById(id);
//		if (person1.isPresent()) {			
//		
//		return personRepository.deleteById(person1)};
//		return null;
//	}

//	@Override
//	public Set<Person> getByTitleAndYear(String partialName) {
//		// TODO Auto-generated method stub
//		return null;
//	} 
//
//
//
//
//
}

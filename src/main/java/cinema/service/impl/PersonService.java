package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;



@Service
@Transactional
public class PersonService implements cinema.service.IPersonService{

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

//	@Override
//	public Set <Person> getByPartialName(String partialName) {
//		var person1 = personRepository.findByNameContaining(partialName);
//		if (person1.isPresent()) { 
//			return personRepository.findByNameContaining(partialName);			
//		}
//
//		return null;
//	}


@Override
public Optional<Person> deletePerson(int id) {
	var personToDelete = personRepository.findById(id);
	personToDelete.ifPresent(p -> { 
		personRepository.delete(p); 
		personRepository.flush();
		});
	return personToDelete;     }


@Override
public Set<Person> getByPartialName(String partialName) {
	var person1 = personRepository.findByNameContaining(partialName);
	return person1;
}


}


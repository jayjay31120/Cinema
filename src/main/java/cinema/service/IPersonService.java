package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.persistence.entity.Person;

public interface IPersonService {


	List<Person> getAllPersons();
	Optional<Person> getById(int id);
	Person addPerson(Person person);
	Optional<Person> deletePerson(int id);
	Set<Person> getByPartialName(String partialName);
//	Set<Person> getByNationalities(String nationalities);
}

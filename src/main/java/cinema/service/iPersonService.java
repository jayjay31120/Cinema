package cinema.service;

import java.util.List;
import java.util.Set;

import cinema.persistence.entity.Person;

public interface iPersonService {
	List<Person> getAllPersons();
	
	





	Set<Person> addActor();



	Set<Person> deleteActor();



	



	Set<Person> getMovieByPartialTitle(String partialName);

	

}

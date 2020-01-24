package cinema.persistence.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;




public interface PersonRepository extends JpaRepository<Person, Integer> {


	Set<Person> findByName(String name);
	Set<Person>findByNameContaining(String name);
	Set<Person>findByNameEndingWith(String name);

	
	Set<Person>findbyBirthdateYear (int year);
	Set<Person> delete(Optional<Person> person1);
	
	
}

package cinema.persistence.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class TestMovie {

	@Autowired
	MovieRepository rm;
	@Autowired
	PersonRepository repoPerson;

	@Autowired
	EntityManager em;
	
	@Test
	void testInsertsss() {
		Movie m = new Movie("Joker", 2019);
		rm.save(m);
		System.out.println("Movie Joker Id: " + m.getId());
		assertNotNull(m.getId());
	}

	@Test
	void testSelectAll() {
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
				new Movie("Captain America: The First Avenger", 2011, 124),
				new Movie("Gifted ", 2017, 101),
				new Movie("Alita: Battle Angel ", 2017),
				new Movie("The Dark Knight Rises", 2012, 164)
				);
		movies.forEach(em::persist);
		var mRead = rm.findAll();
		mRead.forEach(System.out::println);
		assertEquals(movies.size(), mRead.size());
		assertTrue(mRead.stream()
				.map(Movie::getTitle)
				.allMatch(tRead -> movies.stream()
						.map(Movie::getTitle)
						.anyMatch(tGiven -> tGiven.equals(tRead))
						));

	}

	@Test
	void testFindById() {
		Movie m = new Movie("Gifted ", 2017, 101);
		em.persist(m);
		var id = m.getId();
		var mReadOptional = rm.findById(id);
		System.out.println(mReadOptional);
		assertAll(
				()->assertTrue(mReadOptional.isPresent()),
				()->assertEquals(m.getTitle(), mReadOptional.get().getTitle())
				);
	}
	
	@Test
	void testFindByTitle() {
		String title = "The Lion Kinig";
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
				new Movie("Captain America: The First Avenger", 2011, 124),
				new Movie("Gifted ", 2017, 101),
				new Movie("Alita: Battle Angel ", 2017),
				new Movie(title, 1994),
				new Movie("The Dark Knight Rises", 2012, 164)
				);
		movies.forEach(em::persist);
		var mRead = rm.findByTitle(title);
		System.out.println(mRead);
	}
	
	@Test
	void testFindYear() {
		int year = 2014;
		String title = "Interstellar";
		int startYear = 2009;
		int endYear = 2019;
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
                new Movie("Captain America: The First Avenger", 2011, 124),
                new Movie("Gifted ", 2017, 101),
                new Movie("Alita: Battle Angel ", 2017),
                new Movie("The Dark Knight Rises", 2012, 164),
                new Movie("Spider-Man: Far from Home", 2019, 129),
                new Movie("Interstellar ", 2014, 169),
                new Movie("Gran Torino", 2008, 116),
                new Movie("Ford v Ferrari", 2019, 152)
				);
		movies.forEach(em::persist);
		var mRead = rm.findByYear(year);
		System.out.println("Test: Find by Year: " + mRead);
		var mReadEqual = rm.findByYearLessThanEqual(year);
		System.out.println("Find <= :" + mReadEqual);
		var mReadYearBetween = rm.findByYearBetween(startYear, endYear);
		System.out.println("find Year between: " + mReadYearBetween);
		var mReadTitleAndYear = rm.findByTitleAndYear(title, year);
		System.out.println("Find By Title and Year:" + mReadTitleAndYear);
	}
	
	@Test
	void testFindLessEqualYear() {
		int year = 2011;
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
                new Movie("Captain America: The First Avenger", 2011, 124),
                new Movie("Gifted ", 2017, 101),
                new Movie("Alita: Battle Angel ", 2017),
                new Movie("The Dark Knight Rises", 2012, 164),
                new Movie("Spider-Man: Far from Home", 2019, 129),
                new Movie("Interstellar ", 2014, 169),
                new Movie("Gran Torino", 2008, 116),
                new Movie("Ford v Ferrari", 2019, 152)
				);
		movies.forEach(em::persist);
		var mRead = rm.findByYearLessThanEqual(year);
		System.out.println("Test: Find by Year Less Equal: " + mRead);
	}
	
	@Test
	void testFindYearBetween() {
		int startYear = 2000;
		int endYear = 2019;
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
                new Movie("Captain America: The First Avenger", 2011, 124),
                new Movie("Gifted ", 2017, 101),
                new Movie("Alita: Battle Angel ", 2017),
                new Movie("The Dark Knight Rises", 2012, 164),
                new Movie("Spider-Man: Far from Home", 2019, 129),
                new Movie("Interstellar ", 2014, 169),
                new Movie("Gran Torino", 2008, 116),
                new Movie("Ford v Ferrari", 2019, 152)
				);
		movies.forEach(em::persist);
		var mRead = rm.findByYearBetween(startYear, endYear);
		mRead.forEach(System.out::println);
	}
	
	@Test
	void testFindTitleAndYear() {
		int year = 2017;
		String title = "Alita: Battle Angel";
		List<Movie> movies = List.of(
				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
                new Movie("Captain America: The First Avenger", 2011, 124),
                new Movie("Gifted ", 2017, 101),
                new Movie(title, 2017),
                new Movie("The Dark Knight Rises", 2012, 164),
                new Movie("Spider-Man: Far from Home", 2019, 129),
                new Movie("Interstellar ", 2014, 169),
                new Movie("Gran Torino", 2008, 116),
                new Movie("Ford v Ferrari", 2019, 152)
				);
		movies.forEach(em::persist);
		var mRead = rm.findByTitleAndYear(title, year);
		System.out.println("Test: Find by Title Year: " + mRead);
	}
	
//	@Test
//	void testFindYearBetween2() {
//		int year = 1995;
//		int year2 = 2019;
//		List<Movie> movies = List.of(
//				new Movie("Star Wars: The Rise Of Skywalker", 2019, 144),
//                new Movie("Captain America: The First Avenger", 2011, 124),
//                new Movie("Gifted ", 2017, 101),
//                new Movie("Alita: Battle Angel ", 2017),
//                new Movie("The Dark Knight Rises", 2012, 164),
//                new Movie("Spider-Man: Far from Home", 2019, 129),
//                new Movie("Interstellar ", 2014, 169),
//                new Movie("Gran Torino", 2008, 116),
//                new Movie("Ford v Ferrari", 2019, 152)
//				);
//		movies.forEach(em::persist);
//		var mRead = rm.findByYearBetween(year, year2);
//		System.out.println(mRead);
//		
//		assertAll(
//				() -> assertEquals(9, mRead.size()),
//				() -> assertTrue(mRead.stream()""
//						.mapToInt(Movie::getYear)
//						.allMatch(y -> (y >= year) && (y >= year2)))
//				);
//	}
//	
	@Rollback(false)
	@Test
	void testInsert() {
		Person p = new Person("Clint EastWood", LocalDate.of(1930,5,31), 78, "USA", "beaucoup de films");
//		Movie movie = new Movie("Gran Torino", 2008, 116, p, "ffff", "4,5", "tous publics", "dddddd", "nb", "dd");
		Movie movie1 =  new Movie("X-MEN3", 2016, 98, "action","16/9", "-12ANS", "c'est l'histoire...", "Couleur");
		Person p1 = new Person("Nicolas Cage", LocalDate.of(1955, 4, 22), 32, "USA", "beaucoup de films");
		
	
		rm.save(movie1);
		em.persist(movie1);
		repoPerson.save(p1);
		em.persist(p1);
		
	
		System.out.println(movie1);

	
	}
	

	
}

package cinema.persistence.entity.test;


// this is not a unit test case

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.h2.command.dml.Set;import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestMapping {

	@Autowired
	PersonRepository repoPersons;
	@Autowired
	MovieRepository repoMovies;
	@Autowired
	EntityManager em;

	@Rollback(false)
	@Test
	void test1() {

		var joaq = new Person ("Joaquin Phoenix", LocalDate.of(1974, 10, 28)); 	// 0
		var ger = new Person("Gerard Darmond", LocalDate.of(1948, 2, 29));
		var todd =	new Person("Todd Phillips", LocalDate.of(1970, 12, 20));	//2							// 2
		var clint = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));	// 3
		var brad =new Person("Bradley Cooper", LocalDate.of(1975, 1, 5));		// 4
		var gene= new Person("Gene Hackman", LocalDate.of(1930, 1, 30));  // 5
		var morg = new Person("Morgan Freeman", LocalDate.of(1937, 6, 1));  // 6			

		var persons = List.of(joaq, ger, todd, clint, brad, gene, morg);
		persons.forEach(repoPersons::save);

		var joker =	new Movie("Joker", 2019, 165, todd);			// 0
		var para =	new Movie("Parasite", 2019, 132);				// 1
		var inter =	new Movie("Interstellar", 2014);				// 2
		var gto =	new Movie("Gran Torino", 2008, 116, clint);		// 3
		var impi =	new Movie("Impitoyable", 1992, null, clint);			// 4
		var amsnip =new Movie("American Sniper", 2014, 133, clint);	// 5
		var vbt =	new Movie("Very Bad Trip", 2009, 100, todd);// 6
		var inf = new Movie("Avengers: Infinity War", 2018, 149);
		var end =	new Movie("Avengers: Endgame", 2019, 181);
		var aveng = new Movie("Avengers", 2012, 143);

		var movies = List.of(joker, para, inter, gto, impi, amsnip,vbt,inf,end, aveng);
		movies.forEach(repoMovies::save);

	}


	@Rollback(false)
	@Test
	void test2() {
		var chr = new Person ("Nolan Chrsitopher", LocalDate.of(1970, 7, 30));
		var inter =	new Movie("Interstellar", 2014);

		var result = repoMovies.findByTitle(inter.getTitle());
		repoPersons.save(chr);
		System.out.println(result);
		if (result.size() >0) {
			var interr = result.stream().findFirst().get();
			interr.setDirector(chr);
		}

	}

	@Rollback(false)
	@Test
	void test3 () {
		var chr = new Person ("Nolan Chrsitopher", LocalDate.of(1970, 7, 30));
		var inter =	new Movie("Interstellar", 2014);

		var result = repoMovies.findByTitle(inter.getTitle());
		var interr = result.stream().findFirst().get();
		var direc = interr.getDirector();
		System.out.println(direc);

	}

	@Rollback(false)
	@Test
	void test4 () {
		var joaq = new Person ("Joaquin Phoenix", LocalDate.of(1974, 10, 28)); 	// 0
		var ger = new Person("Gerard Darmond", LocalDate.of(1948, 2, 29));
		var todd =	new Person("Todd Phillips", LocalDate.of(1970, 12, 20));	//2							// 2
		var clint = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));	// 3
		var brad =new Person("Bradley Cooper", LocalDate.of(1975, 1, 5));		// 4
		var gene= new Person("Gene Hackman", LocalDate.of(1930, 1, 30));  // 5
		var morg = new Person("Morgan Freeman", LocalDate.of(1937, 6, 1));  // 6	
		var chr = new Person ("Nolan Chrsitopher", LocalDate.of(1970, 7, 30));

		var persons = List.of(joaq, ger, todd, clint, brad, gene, morg, chr);
		persons.forEach(repoPersons::save);

		var joker =	new Movie("Joker", 2019, 165, todd);			// 0
		var para =	new Movie("Parasite", 2019, 132);				// 1
		var inter =	new Movie("Interstellar", 2014);				// 2
		var gto =	new Movie("Gran Torino", 2008, 116, clint);		// 3
		var impi =	new Movie("Impitoyable", 1992, null, clint);			// 4
		var amsnip =new Movie("American Sniper", 2014, 133, clint);	// 5
		var vbt =	new Movie("Very Bad Trip", 2009, 100, todd);// 6
		var inf = new Movie("Avengers: Infinity War", 2018, 149);
		var end =	new Movie("Avengers: Endgame", 2019, 181);
		var aveng = new Movie("Avengers", 2012, 143);

		var movies = List.of(joker, para, inter, gto, impi, amsnip,vbt,inf,end, aveng);
		movies.forEach(repoMovies::save);

		var batman = new Movie ("Batman Dark Knight", 2008, 153);
		repoMovies.save(batman);

		var nolan = repoPersons.findByNameContaining("Nolan").stream().findFirst().get();
		repoPersons.save(nolan);

		batman.setDirector(nolan);
	}


	@Test
	void scenarioTitrePartiel() {		
		var data = repoMovies.findByTitleContainingIgnoreCase("dark");
		System.out.println(data);


	}
	//repoMovies.flush();

	@Test

	void scenariorecherche() {		
		var result = repoMovies.findByDirectorNameEndingWith("Eastwood");
		var nolan = repoPersons.findByName("Nolan Chrsitopher").stream().findFirst().get();
		var result2 = repoMovies.findByDirector(nolan);
		System.out.println(result);
		System.out.println(result2);

	}


	@Test
	void testLecture() {
		var res = repoPersons.findbyBirthdateYear(1930);
		System.out.println(res);
	}

	@Rollback(false)
	@Test
	void testaddactors(){
		var impi = repoMovies.findByTitle("Impitoyable").stream().findFirst().get();
		var clint = repoPersons.findByName("Clint Eastwood").stream().findFirst().get();
		var gene = repoPersons.findByName("Gene Hackman").stream().findFirst().get();
		impi.setActors(List.of(clint, gene));
		repoMovies.flush();

	}


	@Test
	void testLazyActores () {
		// read a movie : select
		var impitoyable= repoMovies.findByTitle("Impitoyable").stream().findFirst().get();
		//read actors
		//var actors = impitoyable.getActors();
		//System.out.println(actors);

	}
	@Test
	void scenario () {

		var impitoyable= repoMovies.findByTitle("Impitoyable").stream().findFirst().get();
		var morgan = repoPersons.findByName("Morgan Freeman").stream().findFirst().get();
		impitoyable.getActors().add(morgan);
		repoMovies.flush();

	}



	//		@Test
	//		void testcheck() {
	//			var clint = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));
	//			var movieclint = repoMovies.findAll();
	//			var dir = repoPersons.findByName(clint.getName());
	//			var result = movieclint.stream().map(m -> m.getDirector().equals(clint));
	//			result.forEach(System.out::println);
	//			


	@Rollback(false)
	@Test
	void testAddNew (){
		var lpp = new Movie ("Les pleins pouvoirs", 1997, 121);
		repoMovies.save(lpp);
		var gene = repoPersons.findByName("Gene Hackman").stream().findFirst().get();
		var clint = repoPersons.findByName("Clint Eastwood").stream().findFirst().get();
		lpp.getActors().add(gene);
		lpp.getActors().add(clint);
		lpp.setDirector(clint);
		repoMovies.flush();
		
		System.out.println(lpp);
	}
	
	@Test
	void testFindByActorsNameEndingWith() {
		var jok = new Movie("Joker", 2019, 144); 
                var roi = new Movie("Le roi Lion", 1944);
                var arme = new Movie("L'Arme Fatale ", 1987);
                var madmax = new Movie("Mad Max", 1978);
                var gran = new Movie("Gran Torino", 2008, 116);
       	List<Movie> movies = List.of(roi, arme, madmax, gran);
       	movies.forEach(em::persist);
       	
       	var mel = new Person ("Mel Gibson");
       	var wop = new Person ("Whoopi Goldberg");
       	var dan = new Person ("Danny Glover");
       	em.persist(mel);
       	em.persist(wop);
       	em.persist(dan);
       	roi.getActors().add(wop);
       	arme.getActors().add(mel);
       	madmax.getActors().add(mel);
       	arme.getActors().add(dan);
       	Collections.addAll(arme.getActors(), mel, dan);
       	em.flush();
       	var moviesWithMel = repoMovies.findByActorsNameEndingWith("Mel Gibson");
       	assertAll(
       			()->assertTrue(moviesWithMel.contains(madmax), "mad"),
       			()->assertTrue(moviesWithMel.contains(arme), "arme")
//       			()->assertTrue(moviesWithMel.contains(roi), "roi")
       			);

       			}	
}
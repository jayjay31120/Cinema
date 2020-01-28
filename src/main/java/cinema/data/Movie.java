package cinema.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Movie {
	private String title;
	private int year;
	private int duration;
	private Person director;
	private List<Person> actors;
	
	
	//empty Constructor
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, int year) {
		this(title, year, 0, null);
	}

	public Movie(String title, int year, int duration) {
		this(title, year, duration, null);
	}
	
	public Movie(String title, int year, Person director) {
		this(title, year, 0, director);
	}

	public Movie(String title, int year, int duration, Person director) {
		super();
		this.title = Objects.requireNonNull(title);
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.actors = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = Objects.requireNonNull(title);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

	
	@Override
	public String toString() {
		return "Movie: " + (title==null?"UNKNOWN ":title) +" "+ (year==0?"":year) +" " + (duration == 0?"UNKNOWN": duration + "min");
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, year);
	}

	@Override
	public boolean equals(Object obj) {		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Movie other = (Movie) obj;
		return this.title.equals(other.title)
				&& this.year == other.year;
	}

	public void addActor(Person actor) {
		this.actors.add(actor);
	}

	public void addAllActors(Collection<? extends Person> actor) {
		this.actors.addAll(actor);
	}
	
	public void addAllActors(Person... persones) {
		this.addAllActors(Arrays.asList(persones));
	}
	
	public Stream<Person> streamActors(){
		return this.actors.stream();
	}
	
	public Iterator<Person> iteratorActors(){
		return this.actors.iterator();
	}
	
}
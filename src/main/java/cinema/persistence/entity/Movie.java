package cinema.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {


	private Integer id;
	private String title;
	private Integer year;
	private Integer duration;
	private Person director;
	private List<Person> actors;

	public Movie() {
		this(null, null);
	}

	public Movie(String title, Integer year) {
		this(title, year, null);
	}

	public Movie(String title, Integer year, Integer duration) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.actors = new ArrayList<>();
	}

	





	public Movie(String title, Integer year, Integer duration, Person director) {
		this(null, title, year, duration, director);
	}

	public Movie(Integer id, String title, Integer year, Integer duration, Person director) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "year", nullable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	@ManyToOne
	@JoinColumn(name = "director", nullable = true)
	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "act",
		joinColumns=
		@JoinColumn(name= "id_movie"),
		inverseJoinColumns = 
		@JoinColumn(name="id_actor"))
	
	public List<Person> getActors() {
		return actors;
	}
	
	public void setActors(List<Person> actors) {
		this.actors = actors;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(title);
		return builder.append(" (")
				.append(year)
				.append(") ")
				.append("#")
				.append(id)					
				.toString();
	}
	


}
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
	private String genre;
	private Float rating;
	private String format;
	private String classification;
	private String synopsis;
	private String color;

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

	public Movie(String title, Integer year, Integer duration, String genre, Float rating, String format,
			String classification, String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
	}

	public Movie(String title, Integer year, Integer duration, String genre, String format, String classification) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.genre = genre;
		this.format = format;
		this.classification = classification;
	}

	public Movie(String title, Integer year, Integer duration, String format) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.format = format;
	}





	public Movie(String title, Integer year, Integer duration, Person director, String genre, Float rating,
			String format, String classification, String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
	}



	public Movie(Integer id, String title, Integer year, Integer duration, Person director, List<Person> actors,
			String genre, Float rating, String format, String classification, String synopsis) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
	}

	public Movie(String title, Integer year, Integer duration, Person director) {
		this(null, title, year, duration, director);
	}
	

	public Movie(String title, Integer year, Integer duration, String genre, Float rating, String format,
			String classification, String synopsis, String color) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
		this.color = color;
	}

	public Movie(Integer id, String title, Integer year, Integer duration, Person director) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
	}

	
	public Movie(String title, Integer year, Integer duration, Person director, List<Person> actors, String genre,
			Float rating, String format, String classification, String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
	}
	public Movie(String title, Integer year, Integer duration, Person director, List<Person> actors, String genre,
			String format, String classification, String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
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
	
	
	@Column(name = "genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "rating")
	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Column(name ="format")
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	@Column(name ="classication")
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name ="synopsis")
	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}



		
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", duration=" + duration + ", director="
				+ director + ", actors=" + actors + ", genre=" + genre + ", rating=" + rating + ", format=" + format
				+ ", classification=" + classification + ", synopsis=" + synopsis + ", color=" + color + "]";
	}
	
	
	
	
	


}
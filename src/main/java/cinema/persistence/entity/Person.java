package cinema.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Personne")
public class Person {

	private Integer id;
	private String name;
	private LocalDate birthdate;
	private Integer age;
	private String nationalities;
	private String biography;
	



	public Person(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}



	public Person(String name, LocalDate birthdate, Integer age, String nationalities, String biography) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.age = age;
		this.nationalities = nationalities;
		this.biography = biography;
	}



	public Person(String name) {
		this(name, null);
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(name);
		return 	builder.append("(")
				.append(Objects.toString(birthdate, "unknown"))
				.append(") ")
				.append("#")
				.append(id)	
				.toString();
	}	
	public Person(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Person(Integer id, String name, LocalDate birthdate, Integer age, String nationalities, String biography) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.age = age;
		this.nationalities = nationalities;
		this.biography = biography;
	}
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "Nom", nullable = false, length = 55)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Date_Naissance")
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}



@Column(name ="age")
	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	@Column(name ="nationalities")
	public String getNationalities() {
		return nationalities;
	}



	public void setNationalities(String nationalities) {
		this.nationalities = nationalities;
	}


	@Column(name ="biography")
	public String getBiography() {
		return biography;
	}



	public void setBiography(String biography) {
		this.biography = biography;
	}



}

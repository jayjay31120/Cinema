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
	



	public Person(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
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

	public Person(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}



}

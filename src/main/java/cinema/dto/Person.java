package cinema.dto;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {
	private String name;
	private LocalDate birthdate;


	public Person(String name) {
		this(name, null);
	}

	public Person(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public OptionalInt getAge() {
		if (Objects.isNull(birthdate)) {
			OptionalInt.empty();
		}
		
		LocalDate fullDateToday = LocalDate.now();
		MonthDay birthday = MonthDay.of( 
				birthdate.getMonthValue(), 
				birthdate.getDayOfMonth()
				);
		MonthDay today = MonthDay.now();
		int deletaYear = fullDateToday.getYear() - birthdate.getYear();
		
		if (today.compareTo(birthday) < 0) {
			--deletaYear;
		}
		
		return OptionalInt.of(deletaYear);
	}

	@Override
	public String toString() {
		return name + " (" +Objects.toString(birthdate, "unknown") + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, birthdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;

		return this.name.equals(other.name) 
				&& this.birthdate.equals(other.birthdate);
	}
}


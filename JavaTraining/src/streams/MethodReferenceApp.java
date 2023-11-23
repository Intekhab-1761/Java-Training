package streams;

import java.util.Comparator;
import java.util.List;

public class MethodReferenceApp {

	public static void main(String[] args) {

		List<Person> people = List.of(
				new Person("Steve", 40),
				new Person("Brit", 22),
				new Person("Adam", 27),
				new Person("Kumar", 91),
				new Person("Anna", 4),
				new Person("Anna", 12));
		
		people.stream()
		.sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge))
		//.sorted((person1,person2) -> person1.getAge().compareTo(person2.getAge()) )
		.forEach(System.out::println);
	}

}

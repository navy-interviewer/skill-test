package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleProcessorTest {
	
	private PeopleProcessor peopleProcessor = new PeopleProcessor();

	@ParameterizedTest
	@MethodSource("lastnamesByFirstnameTestData")
	public void testLastnamesByFirstname(List<Person> names, Map<String, List<String>> expectedMap, String assertMessage) {
		// WHEN
		Map<String, List<String>> lastNamesByFirstName = peopleProcessor.lastnamesByFirstname(names);
		
		// THEN
		assertEquals(expectedMap, lastNamesByFirstName, assertMessage);
	}
	private static Stream<Arguments> lastnamesByFirstnameTestData() {
	    Person johnDoe = new Person("John", "Doe");
		Person jackBurns = new Person("Jack", "Burns");
		Person johnBurns = new Person("John", "Burns");
		Person johnSilver = new Person("John", "Silver");
		Person peterDoe = new Person("Peter", "Doe");
		// ["John Doe", "John Silver", "Peter Doe"]
		return Stream.of(
	      Arguments.of(null, Map.of(), "null person"),
	      Arguments.of(List.of(), Map.of(), "no person"),
	      Arguments.of(List.of(johnDoe), Map.of("John", List.of("Doe")), "one person"),
	      Arguments.of(List.of(johnDoe, jackBurns),
	    		  Map.of("John", List.of("Doe"), "Jack", List.of("Burns")), "Two persons, different first names"),
	      Arguments.of(List.of(johnDoe, johnBurns),
	    		  Map.of("John", List.of("Doe", "Burns")), "Two persons, same first names"),
	      Arguments.of(List.of(johnDoe, johnSilver, peterDoe),
	    		  Map.of("John", List.of("Doe", "Silver"), "Peter", List.of("Doe")), "Official test data")
	      
	    );
	}
	

	@ParameterizedTest
	@MethodSource("firstNamesByLastNameTestData")
	public void testFirstnamesBylastName(List<Person> names, Map<String, List<String>> expectedMap, String assertMessage) {
		// WHEN
		Map<String, List<String>> lastNamesByFirstName = peopleProcessor.firstnamesByLastname(names);
		
		// THEN
		assertEquals(expectedMap, lastNamesByFirstName, assertMessage);
	}
	private static Stream<Arguments> firstNamesByLastNameTestData() {
	    Person johnDoe = new Person("John", "Doe");
		Person johnSilver = new Person("John", "Silver");
		Person peterDoe = new Person("Peter", "Doe");
		return Stream.of(
	      Arguments.of(null, Map.of(), "null person"),
	      Arguments.of(List.of(), Map.of(), "no person"),
	      Arguments.of(List.of(johnDoe), Map.of("Doe", List.of("John")), "one person"),
	      Arguments.of(List.of(johnDoe, peterDoe),
	    		  Map.of("Doe", List.of("John", "Peter")), "two persons, same last name"),
	      Arguments.of(List.of(johnDoe, johnSilver),
	    		  Map.of("Doe", List.of("John"), "Silver", List.of("John")), "two persons, different last name"),
	      Arguments.of(List.of(johnDoe, johnSilver, peterDoe),
	    		  Map.of("Doe", List.of("John", "Peter"), "Silver", List.of("John")), "Official test data")
	    );
	}
}

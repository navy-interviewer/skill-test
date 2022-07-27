package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleProcessorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void firstnamesByLastnameWhenThereIsNotAnyPeopleThereIsNoError(List<Person> people) {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertTrue(result.isEmpty());
    }

    @Test
    void firstnamesByLastnameWhenThereAreSeveralPeopleAreProvidedThenSucceeds() {
        List<Person> people = Stream.of(new Person("John", "Doe"),
                        new Person(null, "x"),
                        new Person("JOHN", "Doe"),
                        new Person("G.I.", "Joe"),
                        new Person("y", null))
                .collect(toList());

        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertEquals(4, result.size());
        assertTrue(result.keySet().containsAll(people.stream()
                .map(person -> ofNullable(person.getLastName())
                        .orElse("N/A").toUpperCase())
                .distinct()
                .collect(toList())));
        assertEquals(2, result.get("DOE").size());
        assertEquals(1, result.get("X").size());
        assertEquals(1, result.get("N/A").size());
        assertEquals(1, result.get("JOE").size());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void lastnamesByFirstnameWhenThereIsNotAnyPeopleThereIsNoError(List<Person> people) {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertTrue(result.isEmpty());
    }

    @Test
    void lastnamesByFirstnameWhenThereAreSeveralPeopleAreProvidedThenSucceeds() {
        List<Person> people = Stream.of(new Person("John", "DOE"),
                        new Person("JOHN", "Doe"),
                        new Person("G.I.", "Joe"),
                        new Person(null, "x"))
                .collect(toList());

        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertEquals(3, result.size());
        assertTrue(result.keySet().containsAll(people.stream()
                .map(person -> ofNullable(person.getFirstName())
                        .orElse("N/A").toUpperCase())
                .distinct()
                .collect(toList())));
        assertEquals(2, result.get("JOHN").size());
        assertEquals(1, result.get("N/A").size());
        assertEquals(1, result.get("G.I.").size());
    }

}
package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PeopleProcessorTest {

    @Test
    void lastnamesByFirstnameShouldGroup() {
        List<Person> people = unmodifiableList(
                asList(
                        new Person("John", "Doe"),
                        new Person("John", "Silver"),
                        new Person("Peter", "Doe")
                ));

        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertEquals(2, result.size());
        assertEquals(unmodifiableList(asList("Doe", "Silver")), result.get("John"));
        assertEquals(singletonList("Doe"), result.get("Peter"));
    }

    @Test
    void lastnamesByFirstnameShouldHandleEmptyInput() {
        List<Person> people = emptyList();

        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertEquals(0, result.size());
    }

    @Test
    void lastnamesByFirstnameShouldHandleNulls() {
        List<Person> people = unmodifiableList(
                asList(
                        null,
                        new Person("John", null),
                        new Person("John", "Silver"),
                        new Person(null, "Doe")
                ));

        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertEquals(1, result.size());
        assertEquals(unmodifiableList(asList(null, "Silver")), result.get("John"));
    }

    @Test
    void firstnamesByLastnameShouldGroup() {
        List<Person> people = unmodifiableList(
                asList(
                        new Person("John", "Doe"),
                        new Person("John", "Silver"),
                        new Person("Peter", "Doe")
                ));

        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertEquals(2, result.size());
        assertEquals(unmodifiableList(asList("John", "Peter")), result.get("Doe"));
        assertEquals(singletonList("John"), result.get("Silver"));
    }

    @Test
    void firstnamesByLastnameShouldHandleEmptyInput() {
        List<Person> people = emptyList();

        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertEquals(0, result.size());
    }

    @Test
    void firstnamesByLastnameShouldHandleNulls() {
        List<Person> people = unmodifiableList(
                asList(
                        null,
                        new Person("John", null),
                        new Person("John", "Silver"),
                        new Person(null, "Doe"),
                        new Person("Alf", "Doe")
                ));

        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertEquals(2, result.size());
        assertEquals(singletonList("John"), result.get("Silver"));
        assertEquals(unmodifiableList(asList(null, "Alf")), result.get("Doe"));
    }
}

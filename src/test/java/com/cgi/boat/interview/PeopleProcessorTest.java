package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.cgi.boat.interview.PeopleProcessor.displayTopThreeMostOccurrencesFirstNames;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;


class PeopleProcessorTest {

    private List<Person> people;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        people = PeopleSetupTest.people;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testLastnamesByFirstname() {
        List<Person> people1 = people;
        Map<String, List<String>> result =
                people1.stream().collect(groupingBy(
                        Person::getFirstName,
                        Collectors.mapping(
                                Person::getLastName, Collectors.toList()))
                );
        assertEquals(5, result.size());
    }

    @Test
    public void testFirstnamesByLastname() {
        List<Person> people1 = people;
        Map<String, List<String>> result =
                people1.stream().collect(groupingBy(
                        Person::getLastName,
                        Collectors.mapping(
                                Person::getFirstName, Collectors.toList()))
                );

        assertEquals(7, result.size());
    }

    @Test
    public void testOccurrenceOfFirstName() {
        List<Person> people1 = people;
        displayTopThreeMostOccurrencesFirstNames(
                PeopleProcessor.orderingByOccurrence(
                        PeopleProcessor.mappingByOccurrence(people1)));
    }
}
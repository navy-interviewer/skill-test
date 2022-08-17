package com.cgi.boat.interview;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cgi.boat.interview.PeopleProcessor.firstnamesByLastname;
import static com.cgi.boat.interview.PeopleProcessor.lastnamesByFirstname;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PeopleProcessorTest {
    private static final List<Person> people = asList(new Person("John", "Doe"), new Person("John", "Silver"), new Person("Peter", "Doe"));

    @Test
    public void shouldGroupLastnamesByFirstname() {
        assertEquals(ImmutableMap.of("John", asList("Doe", "Silver"), "Peter", singletonList("Doe")), lastnamesByFirstname(people));
    }

    @Test
    public void shouldGroupFirstnamesByLastname() {
        assertEquals(ImmutableMap.of("Doe", asList("John", "Peter"), "Silver", singletonList("John")), firstnamesByLastname(people));
    }
}
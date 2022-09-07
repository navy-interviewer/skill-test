package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleProcessorTest {
    @Test
    public void test_lastnamesByFirstname_nullList() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(null);

        assertTrue(result.isEmpty());
    }

    @Test
    public void test_lastnamesByFirstname_notNullList() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(createPersons());

        assertEquals(2, result.get("John").size());
        assertTrue(result.get("John").containsAll(Arrays.asList("Doe", "Silver")));
    }

    @Test
    public void test_firstnamesByLastname_nullList() {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(null);

        assertTrue(result.isEmpty());
    }

    @Test
    public void test_firstnamesByLastname_notNullList() {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(createPersons());

        assertEquals(2, result.get("Doe").size());
        assertTrue(result.get("Doe").containsAll(Arrays.asList("John", "Peter")));
    }

    private List<Person> createPersons() {
        return Arrays.asList(
                new Person("John", "Doe"),
                new Person("John", "Silver"),
                new Person("Peter", "Doe")
        );
    }
}

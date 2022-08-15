package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class PeopleProcessorTest {

    public static final List<Person> SIMPLE_PERSON_LIST = Arrays.asList(new Person("John", "Doe"), new Person("John", "Silver"), new Person("Peter", "Doe"));

    @Test
    void lastnamesByFirstname_big_list() {
        Map<String, List<String>> map = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        Assertions.assertEquals(305, map.keySet().size());
    }

    // firstnamesByLastname

    @Test
    void firstnamesByLastname_input_is_null() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(null);
        Assertions.assertEquals(0, map.keySet().size());
    }

    @Test
    void firstnamesByLastname_input_is_empty_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(Collections.emptyList());
        Assertions.assertEquals(0, map.keySet().size());
    }

    @Test
    void firstnamesByLastname_simple_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(SIMPLE_PERSON_LIST);
        Assertions.assertEquals(2, map.keySet().size());
    }

    @Test
    void firstnamesByLastname_big_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Assertions.assertEquals(540, map.keySet().size());
    }

    // Auxiliary tests

    @Test
    void firstnamesCount() {
        HashSet<String> set = new HashSet<>();
        PeopleSetup.people.forEach(person -> set.add(person.getFirstName()));
        Assertions.assertEquals(305, set.size());
    }

    @Test
    void lastnamesCount() {
        HashSet<String> set = new HashSet<>();
        PeopleSetup.people.forEach(person -> set.add(person.getLastName()));
        Assertions.assertEquals(540, set.size());
    }

}

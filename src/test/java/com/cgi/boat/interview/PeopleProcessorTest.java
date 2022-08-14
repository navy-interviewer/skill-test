package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class PeopleProcessorTest {

    public static final List<Person> PEOPLE = Arrays.asList(new Person("John", "Doe"), new Person("John", "Silver"), new Person("Peter", "Doe"));

    @Test
    void lastnamesByFirstname() {
    }

    // firstnamesByLastname

    @Test
    void firstnamesByLastname_input_is_null() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(null);
        Assertions.assertEquals(map.keySet().size(), 0);
    }

    @Test
    void firstnamesByLastname_input_is_empty_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(Collections.emptyList());
        Assertions.assertEquals(map.keySet().size(), 0);
    }

    @Test
    void firstnamesByLastname_simple_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PEOPLE);
        Assertions.assertEquals(map.keySet().size(), 2);
    }

}

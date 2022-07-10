package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PeopleProcessorTest {

    @Test
    public void testLastnamesByFirstname() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(Arrays.asList(new Person("John", "Doe"), new Person("John", "Silver"), new Person("Peter", "Doe")));
        assertNotNull(result, "result should not be null");
        assertEquals(result.size(), 2, "result size should be 2");

        assertNotNull(result.get("John"));
        assertEquals(result.get("John").size(), 2, "John key should contain 2 values");
        assertTrue(result.get("John").contains("Doe"), "John key should contain Doe value");
        assertTrue(result.get("John").contains("Silver"), "John key should contain Silver value");

        assertNotNull(result.get("Peter"));
        assertEquals(result.get("Peter").size(), 1, "Peter key should contain 1 value");
        assertTrue(result.get("Peter").contains("Doe"), "Peter key should contain Doe value");
    }

    @Test
    public void testFirstnamesByLastname() {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(Arrays.asList(new Person("John", "Doe"), new Person("John", "Silver"), new Person("Peter", "Doe")));
        assertNotNull(result, "result should not be null");
        assertEquals(result.size(), 2, "result size should be 2");

        assertNotNull(result.get("Doe"));
        assertEquals(result.get("Doe").size(), 2, "Doe key should contain 2 values");
        assertTrue(result.get("Doe").contains("John"), "Doe key should contain John value");
        assertTrue(result.get("Doe").contains("Peter"), "Doe key should contain Peter value");

        assertNotNull(result.get("Silver"));
        assertEquals(result.get("Silver").size(), 1, "Silver key should contain 1 value");
        assertTrue(result.get("Silver").contains("John"), "Silver key should contain John value");
    }
}
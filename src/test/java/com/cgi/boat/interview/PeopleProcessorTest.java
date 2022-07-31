package com.cgi.boat.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeopleProcessorTest {

    private static final String FIRSTNAME = "Foo";

    private static final String LASTNAME = "Bar";

    @Test
    public void testEmptyArgument() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(Collections.emptyList());
        assertEquals(0, result.size());
    }


    @Test
    public void testSinglePerson() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(Collections.singletonList(new Person(FIRSTNAME, LASTNAME)));
        assertEquals(1, result.size());
        assertTrue(result.containsKey(FIRSTNAME));
        assertEquals(Collections.singletonList(LASTNAME), result.get(FIRSTNAME));
    }

    @Test
    public void testMultiplePerson() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(Arrays.asList(
                new Person(FIRSTNAME, LASTNAME),
                new Person(FIRSTNAME + "1", LASTNAME + "1")
        ));
        assertEquals(2, result.size());
        assertTrue(result.containsKey(FIRSTNAME));
        assertTrue(result.containsKey(FIRSTNAME + "1"));
        assertEquals(Collections.singletonList(LASTNAME), result.get(FIRSTNAME));
        assertEquals(Collections.singletonList(LASTNAME + "1"), result.get(FIRSTNAME + "1"));
    }


    @Test
    public void testMultipleLastNameForFirstName() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(Arrays.asList(
                new Person(FIRSTNAME, LASTNAME),
                new Person(FIRSTNAME, LASTNAME + "1")
        ));
        assertEquals(1, result.size());
        assertTrue(result.containsKey(FIRSTNAME));
        assertEquals(Arrays.asList(LASTNAME, LASTNAME + "1"), result.get(FIRSTNAME));
    }


}

package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.cgi.boat.interview.TestNamesFixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleProcessorTest {

    @Test
    void whenEmptyInput_shouldReturnEmptyMap() {
        assertTrue(PeopleProcessor.lastnamesByFirstname(Collections.emptyList()).isEmpty());
        assertTrue(PeopleProcessor.firstnamesByLastname(Collections.emptyList()).isEmpty());
    }

    @Test
    void whenNullInput_shouldReturnEmptyMap() {
        assertTrue(PeopleProcessor.lastnamesByFirstname(null).isEmpty());
        assertTrue(PeopleProcessor.firstnamesByLastname(null).isEmpty());
    }

    @Test
    void shouldReturnLastnamesByFirstname() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(PEOPLE1);

        assertEquals(2, result.size());
        assertEquals(2, result.get(JOHN).size());
        assertTrue(result.get(JOHN).containsAll(List.of(DOE, SILVER)));
        assertEquals(1, result.get(PETER).size());
        assertTrue(result.get(PETER).contains(DOE));
    }

    @Test
    void shouldReturnFirstnamesByLastname() {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(PEOPLE1);

        assertEquals(2, result.size());
        assertEquals(2, result.get(DOE).size());
        assertTrue(result.get(DOE).containsAll(List.of(JOHN, PETER)));
        assertEquals(1, result.get(SILVER).size());
        assertTrue(result.get(SILVER).contains(JOHN));
    }

    @Test
    void shouldFindMostCommonFirstNames() {
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PEOPLE2);

        List<Map.Entry<String, List<String>>> result = PeopleProcessor.findMostCommonNames(lastByFirst, 3);

        assertEquals(3, result.size());

        assertEquals(3, result.get(0).getValue().size());
        assertEquals(JOHN, result.get(0).getKey());
        assertTrue(result.get(0).getValue().containsAll(List.of(DOE, SILVER, ACHESON)));

        assertEquals(3, result.get(1).getValue().size());
        assertEquals(PETER, result.get(1).getKey());
        assertTrue(result.get(1).getValue().containsAll(List.of(ARNE, BYWATER)));

        assertEquals(1, result.get(2).getValue().size());
        assertEquals(EARL, result.get(2).getKey());
        assertTrue(result.get(2).getValue().contains(DOE));
    }

}
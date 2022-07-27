package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleFinderTest {

    private final int MAX_LENGTH_OF_THE_LIST = 3;

    @ParameterizedTest
    @NullAndEmptySource
    void findTheMostFrequentFirstNamesWhenThereIsNotAnyPeopleThereIsNoError(Map<String, List<String>> mapByFirstName) {
        List<PersonListDto> result = PeopleFinder.findTheMostFrequentFirstNames(mapByFirstName, MAX_LENGTH_OF_THE_LIST);

        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void findTheMostFrequentFirstNamesWhenInvalidNumberIsSpecifiedThereIsNoError(int number) {
        Map<String, List<String>> mapByFirstName = new HashMap<String, List<String>>() {{
            put("John", Arrays.asList("Doe,", "Smith"));
        }};
        List<PersonListDto> result = PeopleFinder.findTheMostFrequentFirstNames(mapByFirstName, number);

        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {MAX_LENGTH_OF_THE_LIST, Integer.MAX_VALUE})
    void findTheMostFrequentFirstNamesWhenThereAreLessPeopleThanExpectedThenSucceeds(int number) {
        Map<String, List<String>> mapByFirstName = new HashMap<String, List<String>>() {{
            put("John", Arrays.asList("Doe,", "Smith"));
            put("Alvin", Collections.singletonList("Smith"));
        }};

        List<PersonListDto> result = PeopleFinder.findTheMostFrequentFirstNames(mapByFirstName, number);

        assertEquals(mapByFirstName.size(), result.size());
        assertTrue(result.stream()
                .map(PersonListDto::getName)
                .collect(Collectors.toList())
                .containsAll(mapByFirstName.keySet()));
        for (PersonListDto personListDto : result) {
            assertEquals(mapByFirstName.get(personListDto.getName()).size(), personListDto.getFrequency());
        }
    }

    @Test
    void findTheMostFrequentFirstNamesWhenThereAreSeveralPeopleAreProvidedThenSucceeds() {
        Map<String, List<String>> mapByFirstName = new HashMap<String, List<String>>() {{
            put("John", Arrays.asList("Doe,", "Smith"));
            put("Alvin", Collections.singletonList("Smith"));
            put("Harry", Arrays.asList("Potter", "Smith", "White"));
            put("Isaac", Collections.singletonList("Asimov"));
        }};

        List<PersonListDto> result = PeopleFinder.findTheMostFrequentFirstNames(mapByFirstName, MAX_LENGTH_OF_THE_LIST);

        assertEquals(MAX_LENGTH_OF_THE_LIST, result.size());
        assertEquals("Harry", result.get(0).getName());
        assertEquals("John", result.get(1).getName());
        assertEquals("Alvin", result.get(2).getName());
        assertEquals(mapByFirstName.get("Harry").size(), result.get(0).getFrequency());
        assertEquals(mapByFirstName.get("John").size(), result.get(1).getFrequency());
        assertEquals(mapByFirstName.get("Alvin").size(), result.get(2).getFrequency());
    }

}
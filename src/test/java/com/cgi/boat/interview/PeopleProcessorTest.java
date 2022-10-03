package com.cgi.boat.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Collections.EMPTY_LIST;
import static org.assertj.core.api.Assertions.assertThat;

public class PeopleProcessorTest {
    private final List<Person> people = Arrays.asList(new Person("John", "Doe"),
            new Person("John", "Silver"),
            new Person("Peter", "Doe"));

    @Test
    public void lastnamesByFirstnameTest() {
        Map<String, List<String>> result = PeopleProcessor.lastnamesByFirstname(people);

        assertThat(result.get("John"))
                .hasSize(2)
                .contains("Doe", "Silver");
        assertThat(result.get("Peter"))
                .hasSize(1)
                .contains("Doe");

    }

    @Test
    public void lastnamesByFirstnameEmptyListTest() {
        assertThat(PeopleProcessor.lastnamesByFirstname(EMPTY_LIST))
                .isEmpty();
    }

    @Test
    public void firstnamesByLastnameEmptyListTest() {
        assertThat(PeopleProcessor.firstnamesByLastname(EMPTY_LIST))
                .isEmpty();
    }

    @Test
    public void firstnamesByLastnameTest() {
        Map<String, List<String>> result = PeopleProcessor.firstnamesByLastname(people);

        assertThat(result.get("Doe"))
                .hasSize(2)
                .contains("John", "Peter");
        assertThat(result.get("Silver"))
                .hasSize(1)
                .contains("John");

    }

    @Test
    public void sortedByOccurrencesEmptyMapTest() {
        Map<String, List<String>> collectedNames = PeopleProcessor.lastnamesByFirstname(EMPTY_LIST);

        List<PersonWithOccurrence> result = PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(collectedNames);

        assertThat(result)
                .isEmpty();
    }

    @Test
    public void sortedByOccurrencesTest() {
        Map<String, List<String>> collectedNames = PeopleProcessor.lastnamesByFirstname(people);

        List<PersonWithOccurrence> result = PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(collectedNames);

        assertThat(result)
                .hasSize(2);
        assertThat(result.get(0).getName())
                .isEqualTo("John");
        assertThat(result.get(0).getOccurrence())
                .isEqualTo(2);
        assertThat(result.get(1).getName())
                .isEqualTo("Peter");
        assertThat(result.get(1).getOccurrence())
                .isEqualTo(1);
    }

}
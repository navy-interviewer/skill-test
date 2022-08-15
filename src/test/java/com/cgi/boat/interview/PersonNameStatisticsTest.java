package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class PersonNameStatisticsTest {

    @Test
    public void test_most_frequent_lastname() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = PersonNameStatistics.mostFrequent(map, 1);
        Assertions.assertEquals(mostFrequent.get(0).getKey(), "Simpson");
    }

    @Test
    public void test_most_frequent_firstname() {
        Map<String, List<String>> map = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = PersonNameStatistics.mostFrequent(map, 1);
        Assertions.assertEquals(mostFrequent.get(0).getKey(), "John");
    }

    @Test
    public void test_second_most_frequent_firstname() {
        Map<String, List<String>> map = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = PersonNameStatistics.mostFrequent(map, 2);
        Assertions.assertEquals(mostFrequent.get(1).getKey(), "Peter");
    }

    @Test
    public void test_second_most_frequent_lastname() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = PersonNameStatistics.mostFrequent(map, 2);
        Assertions.assertEquals(mostFrequent.get(1).getKey(), "Harris");
    }

    @Test
    void test_invalid_head_size() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Assertions.assertThrows(IllegalArgumentException.class, () -> PersonNameStatistics.mostFrequent(map, 0));
    }

    @Test
    public void test() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = PersonNameStatistics.mostFrequent(map, 10);
        mostFrequent.forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}

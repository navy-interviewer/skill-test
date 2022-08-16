package com.cgi.boat.interview;

import com.cgi.boat.interview.ranking.MultiRankingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class PersonNameStatisticsTest {

    PersonNameStatistics personNameStatistics = new PersonNameStatistics(new MultiRankingStrategy());

    @Test
    public void test_most_frequent_lastname() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = personNameStatistics.popularity(map, 1);
        Assertions.assertEquals(mostFrequent.get(0).getKey(), "Simpson");
    }

    @Test
    public void test_most_frequent_firstname() {
        Map<String, List<String>> map = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = personNameStatistics.popularity(map, 1);
        Assertions.assertEquals(mostFrequent.get(0).getKey(), "John");
    }

    @Test
    public void test_second_most_frequent_firstname() {
        Map<String, List<String>> map = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = personNameStatistics.popularity(map, 2);
        Assertions.assertEquals(mostFrequent.get(1).getKey(), "Peter");
    }

    @Test
    public void test_second_most_frequent_lastname() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = personNameStatistics.popularity(map, 2);
        Assertions.assertEquals(mostFrequent.get(1).getKey(), "Harris");
    }

}

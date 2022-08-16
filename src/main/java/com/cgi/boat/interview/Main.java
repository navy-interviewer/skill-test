package com.cgi.boat.interview;

import com.cgi.boat.interview.ranking.MultiRankingStrategy;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3

        // Different ranking strategies are possible, simple, multi, ...
        // using multi here
        PersonNameStatistics personNameStatistics = new PersonNameStatistics(new MultiRankingStrategy());

        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        List<Map.Entry<String, Integer>> mostFrequent = personNameStatistics.popularity(map, 2);
        mostFrequent.forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

    }

}

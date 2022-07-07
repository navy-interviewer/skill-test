package com.cgi.boat.interview;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int MOST_COMMON_FIRST_NAMES_LIMIT = 3;

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        System.out.println(MOST_COMMON_FIRST_NAMES_LIMIT + " most common first names are: ");
        lastByFirst.entrySet()
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().size()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(MOST_COMMON_FIRST_NAMES_LIMIT)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}

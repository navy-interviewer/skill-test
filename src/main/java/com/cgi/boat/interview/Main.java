package com.cgi.boat.interview;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        getTopOccurrences(lastByFirst, 3)
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue().size())
                .forEach(System.out::println);
    }

    public static Map<String, List<String>> getTopOccurrences(Map<String, List<String>> groups, int limit) {
        return groups
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(o -> o.getValue().size())))
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> {
                    throw new IllegalArgumentException("Input contains 2 groups with the same key!");
                }, LinkedHashMap::new));
    }
}

package com.cgi.boat.interview;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        lastByFirst.entrySet().stream()
                .sorted(Collections.reverseOrder(comparingByValue(comparingInt(List::size)))).limit(3)
                .collect(toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new
                        )
                ).entrySet().forEach(person -> System.out.println(person.getKey() + ": " + person.getValue().size()));
    }
}

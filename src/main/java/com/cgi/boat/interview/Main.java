package com.cgi.boat.interview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        lastByFirst.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(3)
                .forEach(elem->System.out.printf("%s: %s%n",elem.getKey(),elem.getValue()));
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
    }


}

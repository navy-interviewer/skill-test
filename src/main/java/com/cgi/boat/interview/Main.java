package com.cgi.boat.interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences

        System.out.println("firstByLast:");
        printMostCommonNamesWithOccurrences(3, firstByLast);
        System.out.println("\nlastByFirst:");
        printMostCommonNamesWithOccurrences(3, lastByFirst);
    }
    // for example:
    // Homer: 32
    // Bart: 21
    // William: 3

    private static void printMostCommonNamesWithOccurrences(final int numberOfFistNames,
                                                            final Map<String, List<String>> mapByNames) {

        mapByNames.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .limit(numberOfFistNames)
                .forEach(entry ->
                        System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()))
                );
    }

}

package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        System.out.println("firstByLast:");
        //TODO: What's going on then the occurrences were equal?
        //This part has not specified
        printNamesWithOccurrence(PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(firstByLast), 3);
        System.out.println("-------------------------------");
        System.out.println("lastByFirst:");
        printNamesWithOccurrence(PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(lastByFirst), 3);
        System.out.println();
        //First suggest Print Solution:
        recommendPrintSolution(firstByLast, lastByFirst);

    }

    private static void recommendPrintSolution(final Map<String, List<String>> firstByLast, final Map<String, List<String>> lastByFirst) {
        System.out.println("First suggest--------------------");
        System.out.println("firstByLast:");
        printNamesWithOccurrenceRecommend(PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(firstByLast), 3);
        System.out.println("-------------------------------");
        System.out.println("lastByFirst:");
        printNamesWithOccurrenceRecommend(PeopleProcessor.asPeopleWithOccurrencesSortedDescByOccurrences(lastByFirst), 3);
    }

    private static void printNamesWithOccurrence(final List<PersonWithOccurrence> asSortedAscByOccurrences, final int howMuchShow) {
        asSortedAscByOccurrences
                .stream()
                .limit(howMuchShow)
                .forEach(System.out::println);
    }

    private static void printNamesWithOccurrenceRecommend(final List<PersonWithOccurrence> asSortedAscByOccurrences, final int howMuchShow) {
        asSortedAscByOccurrences
                .stream()
                .collect(Collectors.groupingBy(PersonWithOccurrence::getOccurrence, Collectors.mapping(PersonWithOccurrence::getName, Collectors.toList())))
                .entrySet()
                .stream()
                .map(no -> new PersonsWithOccurrence(no.getKey(), no.getValue()))
                .sorted()
                .limit(howMuchShow)
                .forEachOrdered(System.out::println);
    }
}

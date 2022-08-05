package com.cgi.boat.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cgi.boat.interview.PeopleSetup.people;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

class PeopleProcessor {
    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "John" -> ["Doe", "Silver"]
     *  "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        return people.stream().collect(groupingBy(
                Person::getFirstName, Collectors.mapping(Person::getLastName, Collectors.toList())));
    }


    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "Doe" -> ["John", "Peter"]
     *  "Silver" -> ["John"]
     *
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people){
        return people.stream().collect(groupingBy(
                Person::getLastName, Collectors.mapping(Person::getFirstName, Collectors.toList())));
    }

    static Map<String, Long> mappingByOccurrence(List<Person> people) {
        return people.stream().collect(groupingBy(
                Person::getFirstName,
                counting()));
    }

    static Map<String, Long> orderingByOccurrence(Map<String, Long> mappedOccurrences) {
        return mappedOccurrences.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(
                        comparingByValue()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
    }

    static void displayTopThreeMostOccurrencesFirstNames(Map<String, Long> sortedMap) {
        sortedMap.entrySet().stream().limit(3).forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}

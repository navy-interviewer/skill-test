package com.cgi.boat.interview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
        return grouping(people, Person::getFirstName, Person::getLastName);
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
        return grouping(people, Person::getLastName, Person::getFirstName);
    }

    private static Map<String, List<String>> grouping(List<Person> people, Function<Person, String> grouping, Function<Person, String> mapping) {
        return people.stream()
                .collect(Collectors.groupingBy(grouping))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().map(mapping).collect(Collectors.toList())));
    }

}

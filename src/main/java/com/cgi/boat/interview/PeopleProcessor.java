package com.cgi.boat.interview;

import java.util.*;
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
    static Map<String, List<String>> lastnamesByFirstname(final List<Person> people) {
        return groupBy(people, Person::getFirstName, Person::getLastName);
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
    static Map<String, List<String>> firstnamesByLastname(final List<Person> people) {
        return groupBy(people, Person::getLastName, Person::getFirstName);
    }

    private static Map<String, List<String>> groupBy(
            final List<Person> people,
            final Function<Person, String> key,
            final Function<Person, String> value) {
        return people.stream().collect(Collectors.groupingBy(key, Collectors.mapping(value, Collectors.toList())));
    }
}

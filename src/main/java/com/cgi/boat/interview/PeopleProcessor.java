package com.cgi.boat.interview;

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
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        Function<Person, String> key = Person::getFirstName;
        Function<Person, String> value = Person::getLastName;
        return getMappedPersonNames(people, key, value);
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
    static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
        Function<Person, String> key = Person::getLastName;
        Function<Person, String> value = Person::getFirstName;
        return getMappedPersonNames(people, key, value);
    }

    private static Map<String, List<String>> getMappedPersonNames(List<Person> people, Function<Person, String> key, Function<Person, String> value) {
        return people.stream().collect(Collectors.groupingBy(
                key,
                Collectors.mapping(value, Collectors.toList())));
    }
}

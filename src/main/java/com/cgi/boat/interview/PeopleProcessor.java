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
     * <p>
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     * "John" -> ["Doe", "Silver"]
     * "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        return grouping(people, Person::getFirstName, Person::getLastName);
    }


    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     * <p>
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     * "Doe" -> ["John", "Peter"]
     * "Silver" -> ["John"]
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
        return grouping(people, Person::getLastName, Person::getFirstName);
    }


    private static Map<String, List<String>> grouping(List<Person> people,
                                                      Function<Person, String> groupingFunction,
                                                      Function<Person, String> mappingFunction) {
        return people.stream().collect(
                Collectors.groupingBy(groupingFunction,
                        Collectors.mapping(mappingFunction, Collectors.toList())
                )
        );
    }
}

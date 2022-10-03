package com.cgi.boat.interview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.toList;

final class PeopleProcessor {
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
    static Map<String, List<String>> lastnamesByFirstname(final List<Person> people){
        if(Objects.isNull(people) || people.isEmpty()){
            return emptyMap();
        }
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getFirstName,
                        Collectors.mapping(Person::getLastName, toList())));
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
    static Map<String, List<String>> firstnamesByLastname(final List<Person> people){
        if(Objects.isNull(people) || people.isEmpty()){
            return emptyMap();
        }
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getLastName,
                        Collectors.mapping(Person::getFirstName, toList())));
    }

    /**
     * Returns a {@link List} where element type is {@link PersonWithOccurrence}
     * The input map of collection names convert to list of PeopleWithOccurrence object
     * and sorted DESC by Occurrence
     *
     */
    static List<PersonWithOccurrence> asPeopleWithOccurrencesSortedDescByOccurrences(final Map<String, List<String>> collectedNames){
        if(Objects.isNull(collectedNames) || collectedNames.isEmpty()){
            return emptyList();
        }
        return collectedNames.entrySet()
                .stream()
                .map(cns-> new PersonWithOccurrence(cns.getKey(), cns.getValue().size()))
                .sorted()
                .collect(toList());
    }
}

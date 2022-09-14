package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Collections.emptyMap;
import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

class PeopleProcessor {

    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     * <p>
     * Example:
     * <p>
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * <p>
     * Expected result would be:
     * <pre>
     * {
     * "John" -> ["Doe", "Silver"]
     * "Peter" -> ["Doe"]
     * }
     * </pre>
     */
    static Map<String, List<String>> lastnamesByFirstname(final List<Person> people) {
        if (people == null) return emptyMap();

        return groupBy(people, Person::firstName, Person::lastName);
    }

    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     * <p>
     * Example:
     * <p>
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * <p>
     * Expected result would be:
     * <pre>
     * {
     * "Doe" -> ["John", "Peter"]
     * "Silver" -> ["John"]
     * }
     * </pre>
     */
    static Map<String, List<String>> firstnamesByLastname(final List<Person> people) {
        if (people == null) return emptyMap();

        return groupBy(people, Person::lastName, Person::firstName);
    }

    private static Map<String, List<String>> groupBy(final List<Person> people,
                                                     final Function<Person, String> classifier,
                                                     final Function<Person, String> mapper) {

        return people.stream().collect(groupingBy(classifier, mapping(mapper, toList())));
    }

    /**
     * Accepts a Map where
     * <p>
     * - keys are first names and values are last names, or
     * <p>
     * -  keys are last names and the values are first names
     * <p>
     * Sorts the map based on the value list element sizes in descending order
     * <p>
     * Then returns the first X most common names specified by the limit argument
     *
     * @param map   the input collection to be sorted
     * @param limit number of most common names to be returned
     * @return List of the most common names
     */
    static List<Map.Entry<String, List<String>>> findMostCommonNames(final Map<String, List<String>> map, final int limit) {

        return map.entrySet().stream()
                .sorted(comparingByValue(comparing(List::size, reverseOrder())))
                .limit(limit)
                .toList();
    }

}

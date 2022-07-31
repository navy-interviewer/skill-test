package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
        return createGroupedMap(people, Person::getFirstName, Person::getLastName);
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
        return createGroupedMap(people, Person::getLastName, Person::getFirstName);
    }

    private static Map<String, List<String>> createGroupedMap(List<Person> people, Function<Person, String> keyFunction, Function<Person, String> valueFunction) {
        return people.parallelStream()
                .collect(HashMap::new,
                        (stringListHashMap, person) -> {
                            String key = keyFunction.apply(person);
                            String value = valueFunction.apply(person);
                            stringListHashMap.computeIfAbsent(key, s -> new ArrayList<>()).add(value);
                        },
                        (stringListHashMap, stringListHashMap2) -> stringListHashMap2.forEach((key, value) ->
                                stringListHashMap.computeIfAbsent(key, s -> new ArrayList<>()).addAll(value)
                        )
                );
    }

}

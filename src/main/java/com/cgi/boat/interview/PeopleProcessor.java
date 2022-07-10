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
        return sortPersonNames(people, Person::getFirstName, Person::getLastName);
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
        return sortPersonNames(people, Person::getLastName, Person::getFirstName);
    }

    private static Map<String, List<String>> sortPersonNames(List<Person> people, Function<Person, String> key, Function<Person, String> value) {
        Map<String, List<String>> lastnamesByFirstName = new HashMap<>();
        people.forEach(person -> {
            List<String> lastNames = lastnamesByFirstName.get(key.apply(person));
            if (lastNames != null) {
                lastNames.add(value.apply(person));
            } else {
                lastNames = new ArrayList<>();
                lastNames.add(value.apply(person));
                lastnamesByFirstName.put(key.apply(person), lastNames);
            }
        });
        return lastnamesByFirstName;
    }
}

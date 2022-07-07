package com.cgi.boat.interview;

import java.util.ArrayList;
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
        return transformPeople(people, Person::getFirstName, Person::getLastName);
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
        return transformPeople(people, Person::getLastName, Person::getFirstName);
    }

    private static Map<String, List<String>> transformPeople(List<Person> people,
                                                             Function<Person, String> keySupplier,
                                                             Function<Person, String> valueSupplier) {
        if (people == null) {
            throw new RuntimeException("Argument 'people' must not be null!");
        }

        if (keySupplier == null) {
            throw new RuntimeException("Argument 'keySupplier' must not be null!");
        }

        if (valueSupplier == null) {
            throw new RuntimeException("Argument 'valueSupplier' must not be null!");
        }

        return people.stream()
                .filter(person -> person.getFirstName() != null && person.getLastName() != null)
                .collect(Collectors.toMap(keySupplier,
                        person -> new ArrayList<String>() {{
                            add(valueSupplier.apply(person));
                        }},
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));
    }
}

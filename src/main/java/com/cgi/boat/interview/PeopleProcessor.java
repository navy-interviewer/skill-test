package com.cgi.boat.interview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, List<String>> result = new HashMap<>();


        Map<String, List<Person>> personsMap = people.stream()
                .collect(Collectors.groupingBy(Person::getFirstName));


        for(Map.Entry<String, List<Person>> firstnameGroup : personsMap.entrySet()) {
            String firstName = firstnameGroup.getKey();
            List<String> lastnames = firstnameGroup.getValue().stream()
                    .map(item -> item.getLastName())
                    .collect(Collectors.toList());
            result.put(firstName, lastnames);
        }

        return result;
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
        Map<String, List<String>> result = new HashMap<>();

        Map<String, List<Person>> personsMap = people.stream()
                .collect(Collectors.groupingBy(Person::getLastName));


        for(Map.Entry<String, List<Person>> lastnameGroup : personsMap.entrySet()) {
            String lastName = lastnameGroup.getKey();
            List<String> firstnames = lastnameGroup.getValue().stream()
                    .map(item -> item.getFirstName())
                    .collect(Collectors.toList());
            result.put(lastName, firstnames);
        }

        return result;
    }

}

package com.cgi.boat.interview;

import java.util.*;

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
        for(Person person: people) {
            addToMap(result, person.getFirstName(), person.getLastName());
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
        for(Person person: people) {
            addToMap(result, person.getLastName(), person.getFirstName());
        }
        return result;
    }

    private static void addToMap(Map<String, List<String>> result, String key, String value) {
        if(result.containsKey(key)) {
            result.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            result.put(key, list);
        }
    }

}

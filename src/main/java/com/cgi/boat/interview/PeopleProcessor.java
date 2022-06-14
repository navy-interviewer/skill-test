package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class PeopleProcessor {
    /*
    * Example:
            * For input: ["John Doe", "John Silver", "Peter Doe"]
            * Expected result would be:
            * {
     *  "John" -> ["Doe", "Silver"]
     *  "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String >> lastnamesByFirstName(List<Person> people){
        Map<String, List<String >> result = new HashMap();

        for (Person person : people) {
            if (!result.containsKey(person.getFirstName())) {
                result.put(person.getFirstName(), new ArrayList<String>());
            }
            result.get(person.getFirstName()).add(person.getLastName());
        }
        return result;
    }

    static Map<String, List<String >> firstnamesByLastname(List<Person> people){
        Map<String, List<String >> result = new HashMap();

        for (Person person : people) {
            if (!result.containsKey(person.getLastName())) {
                result.put(person.getLastName(), new ArrayList<String>());
            }
            result.get(person.getLastName()).add(person.getFirstName());
        }
        return result;
    }
}

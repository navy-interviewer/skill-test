package com.cgi.boat.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class PeopleProcessor {

    private PeopleProcessor() {
    }

    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names of people from the input list who have the first name equal to the
     * key.
     * <p>
     * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        throwErrorIfInputEmptyOrNull(people);

        Map<String, List<String>> returnMap = new HashMap<>();

        for (Person currentPerson : people) {
            populateReturnMap(returnMap, currentPerson.getFirstName(), currentPerson.getLastName());
        }

        return returnMap;
    }

    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping returned is lastname -> firstnames
     * <p>
     * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result would be: { "Doe" -> ["John", "Peter"] "Silver" -> ["John"]
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
        throwErrorIfInputEmptyOrNull(people);

        Map<String, List<String>> returnMap = new HashMap<>();

        for (Person currentPerson : people) {
            populateReturnMap(returnMap, currentPerson.getLastName(), currentPerson.getFirstName());
        }

        return returnMap;
    }

    private static void populateReturnMap(Map<String, List<String>> returnMap, String keyString, String valueString) {
        if (!returnMap.containsKey(keyString)) {
            returnMap.put(keyString, new LinkedList<>());
        }
        returnMap.get(keyString).add(valueString);
    }

    private static void throwErrorIfInputEmptyOrNull(List<Person> people) {
        if (people == null || people.isEmpty()) {
            throw new NullPointerException("Input list was empty");
        }
    }

    static Map<String, Integer> getKeysWithNumberOfOccurences(Map<String, List<String>> inputMap) {
        Map<String, Integer> mapWithOccurences = new HashMap<>();
        for (Map.Entry<String, List<String>> currentEntry : inputMap.entrySet()) {
            mapWithOccurences.put(currentEntry.getKey(), currentEntry.getValue().size());
        }
        return mapWithOccurences;
    }

    static List<String> firstN(Map<String, Integer> map, int n) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                n + 1, Map.Entry.comparingByValue()
        );

        int bound = n + 1;
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            pq.offer(en);
            if (pq.size() == bound) {
                pq.poll();
            }
        }

        int i = n;
        String[] array = new String[n];
        while (--i >= 0) {
            final Map.Entry<String, Integer> entry = pq.remove();
            array[i] = entry.getKey() + ": " + entry.getValue();
        }
        return Arrays.asList(array);
    }

}

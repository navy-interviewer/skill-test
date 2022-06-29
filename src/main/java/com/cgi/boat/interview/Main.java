package com.cgi.boat.interview;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(lastByFirst.entrySet());
        Collections.sort(entryList, Comparator.comparingInt(l -> l.getValue().size()));

        for (int i = entryList.size() - 1; i > entryList.size() - 4; i--) {
            Map.Entry<String, List<String>> entry = entryList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
    }


}

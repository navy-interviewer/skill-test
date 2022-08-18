package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(final String[] args) {
        final Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        final Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        lastByFirst
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> Integer.compare(o2.size(), o1.size())))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() +" : " + entry.getValue().size()));
    }
}

package com.cgi.boat.interview;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        List<SimpleEntry<String, Integer>> firstNameCounts = lastByFirst.entrySet().stream()
                .map(stringListEntry -> new SimpleEntry<>(stringListEntry.getKey(), stringListEntry.getValue().size()))
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());

        if (!firstNameCounts.isEmpty()) {
            byte numberOfProcessedMaxOccurrenceCount = 1;
            int currentOccurrenceNumber = firstNameCounts.get(0).getValue();
            for (SimpleEntry<String, Integer> firstNameCountMapEntry : firstNameCounts) {
                System.out.println(firstNameCountMapEntry.getKey() + ": " + firstNameCountMapEntry.getValue());
                if (currentOccurrenceNumber != firstNameCountMapEntry.getValue()) {
                    if (++numberOfProcessedMaxOccurrenceCount == 3) {
                        break;
                    }
                    currentOccurrenceNumber = firstNameCountMapEntry.getValue();
                }
            }
        }
    }


}

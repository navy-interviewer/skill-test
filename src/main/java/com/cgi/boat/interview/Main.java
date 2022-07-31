package com.cgi.boat.interview;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final int PRINT_LIMIT = 3;

    public static void main(String[] args) {
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        solutionB(lastByFirst);
    }


    private static void solutionA(Map<String, List<String>> lastByFirst) {
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
                    if (++numberOfProcessedMaxOccurrenceCount == PRINT_LIMIT) {
                        break;
                    }
                    currentOccurrenceNumber = firstNameCountMapEntry.getValue();
                }
            }
        }
    }

    private static void solutionB(Map<String, List<String>> lastByFirst) {
        MaxOccurrenceCountHolder maxOccurrenceCountHolder = new MaxOccurrenceCountHolder(PRINT_LIMIT);

        List<SimpleEntry<String, Integer>> firstNameCounts = lastByFirst.entrySet().stream()
                .map(stringListEntry -> {
                    maxOccurrenceCountHolder.compareAndSet(stringListEntry.getValue().size());
                    return new SimpleEntry<>(stringListEntry.getKey(), stringListEntry.getValue().size());
                })
                .collect(Collectors.toList());

        firstNameCounts.stream()
                .filter(stringIntegerSimpleEntry -> maxOccurrenceCountHolder.isIsMaxOccuranceCount(stringIntegerSimpleEntry.getValue()))
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }


}

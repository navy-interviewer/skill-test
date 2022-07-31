package com.cgi.boat.interview;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxOccurrenceCollector {

    static List<AbstractMap.SimpleEntry<String, Integer>> solutionA(Map<String, List<String>> lastByFirst, int printLimit) {
        List<AbstractMap.SimpleEntry<String, Integer>> firstNameCounts = lastByFirst.entrySet().stream()
                .map(stringListEntry -> new AbstractMap.SimpleEntry<>(stringListEntry.getKey(), stringListEntry.getValue().size()))
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());


        List<AbstractMap.SimpleEntry<String, Integer>> collectedNameOccurrences = new ArrayList<>();
        if (!firstNameCounts.isEmpty()) {
            byte numberOfProcessedMaxOccurrenceCount = 1;
            int currentOccurrenceNumber = firstNameCounts.get(0).getValue();
            for (AbstractMap.SimpleEntry<String, Integer> firstNameCountMapEntry : firstNameCounts) {
                collectedNameOccurrences.add(firstNameCountMapEntry);
                if (currentOccurrenceNumber != firstNameCountMapEntry.getValue()) {
                    if (++numberOfProcessedMaxOccurrenceCount == printLimit) {
                        break;
                    }
                    currentOccurrenceNumber = firstNameCountMapEntry.getValue();
                }
            }
        }
        return collectedNameOccurrences;
    }

    static List<AbstractMap.SimpleEntry<String, Integer>> solutionB(Map<String, List<String>> lastByFirst, int printLimit) {
        MaxOccurrenceCountHolder maxOccurrenceCountHolder = new MaxOccurrenceCountHolder(printLimit);

        List<AbstractMap.SimpleEntry<String, Integer>> firstNameCounts = lastByFirst.entrySet().stream()
                .map(stringListEntry -> {
                    maxOccurrenceCountHolder.compareAndSet(stringListEntry.getValue().size());
                    return new AbstractMap.SimpleEntry<>(stringListEntry.getKey(), stringListEntry.getValue().size());
                })
                .collect(Collectors.toList());

        return firstNameCounts.stream()
                .filter(stringIntegerSimpleEntry -> maxOccurrenceCountHolder.isIsMaxOccuranceCount(stringIntegerSimpleEntry.getValue()))
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());
    }


    private static class MaxOccurrenceCountHolder {

        private int[] maxOccurrenceCounts;

        MaxOccurrenceCountHolder(int capacity) {
            this.maxOccurrenceCounts = new int[capacity];
        }

        void compareAndSet(int occurrenceCount) {
            if (occurrenceCount > maxOccurrenceCounts[0]) {
                int indexToRewrite = 0;
                for (; indexToRewrite < maxOccurrenceCounts.length; indexToRewrite++) {
                    if (occurrenceCount <= maxOccurrenceCounts[indexToRewrite]) {
                        if (occurrenceCount == maxOccurrenceCounts[indexToRewrite]) {
                            return;
                        }
                        break;
                    }
                }
                indexToRewrite--;
                if (indexToRewrite >= 0)
                    System.arraycopy(maxOccurrenceCounts, 1, maxOccurrenceCounts, 0, indexToRewrite);
                maxOccurrenceCounts[indexToRewrite] = occurrenceCount;
            }
        }

        boolean isIsMaxOccuranceCount(int occurrenceCount) {
            return occurrenceCount >= maxOccurrenceCounts[0];
        }

    }

}

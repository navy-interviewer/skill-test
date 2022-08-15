package com.cgi.boat.interview;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonNameStatistics {

    public static List<Map.Entry<String, Integer>> mostFrequent(Map<String, List<String>> nameMapping, int headSize) {
        final List<Map.Entry<String, Integer>> occurrences = new ArrayList<>();
        if (nameMapping != null) {
            List<Map.Entry<String, List<String>>> sortedEntries = nameMapping.entrySet().stream()
                    .sorted((b, a) -> Integer.compare(a.getValue().size(), b.getValue().size())) // descending order
                    .collect(Collectors.toList());
            if (headSize < 1) {
                throw new IllegalArgumentException("Value should be at least 1."); //
            }
            final int maxValidIndex = Math.min(sortedEntries.size(), headSize); // deal with the case if headSize is greater than the map itself
            sortedEntries.subList(0, maxValidIndex).forEach(entry -> occurrences.add(
                    new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().size())
            ));
        }
        return occurrences;
    }
}

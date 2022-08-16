package com.cgi.boat.interview.ranking;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleRankingStrategy implements RankingStrategy {
    @Override
    public List<Map.Entry<String, Integer>> apply(int ranks, Map<String, List<String>> nameMapping) {
        List<Map.Entry<String, List<String>>> sortedEntries = sortEntriesByListSizes(nameMapping);

        final int maxValidIndex = Math.min(sortedEntries.size(), ranks); // deal with the case if ranks is greater than the map itself
        List<Map.Entry<String, Integer>> occurrences = new ArrayList<>();

        sortedEntries.subList(0, maxValidIndex).forEach(
                entry -> occurrences.add(new SimpleEntry<>(entry.getKey(), entry.getValue().size()))
        );
        return occurrences;
    }
}

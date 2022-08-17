package com.cgi.boat.interview.ranking;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleRankingStrategy extends SortingBasedRankingStrategy {

    @Override
    protected List<Map.Entry<String, Integer>> applySpecific(int ranks, List<Map.Entry<String, List<String>>> sortedEntries) {
        final int maxValidIndex = Math.min(sortedEntries.size(), ranks); // deal with the case if ranks is greater than the map itself
        List<Map.Entry<String, Integer>> occurrences = new ArrayList<>();

        sortedEntries.subList(0, maxValidIndex).forEach(
                entry -> occurrences.add(new SimpleEntry<>(entry.getKey(), entry.getValue().size()))
        );
        return occurrences;

    }
}

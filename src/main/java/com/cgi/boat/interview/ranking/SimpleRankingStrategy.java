package com.cgi.boat.interview.ranking;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class SimpleRankingStrategy implements RankingStrategy {
    @Override
    public void apply(int ranks, List<Map.Entry<String, Integer>> occurrences, List<Map.Entry<String, List<String>>> sortedEntries) {
        final int maxValidIndex = Math.min(sortedEntries.size(), ranks); // deal with the case if ranks is greater than the map itself
        sortedEntries.subList(0, maxValidIndex).forEach(entry -> occurrences.add(
                new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().size())
        ));
    }
}

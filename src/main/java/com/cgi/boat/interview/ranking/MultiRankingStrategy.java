package com.cgi.boat.interview.ranking;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiRankingStrategy extends SortingBasedRankingStrategy {

    @Override
    protected List<Map.Entry<String, Integer>> applySpecific(int ranks, List<Map.Entry<String, List<String>>> sortedEntries) {
        List<Map.Entry<String, Integer>> occurrences = new ArrayList<>();
        int prevSize = sortedEntries.get(0).getValue().size(); // list is already checked at the caller
        for (int rankIndex = ranks, i = 0; i < sortedEntries.size(); i++) {
            int currentSize = sortedEntries.get(i).getValue().size();
            if (currentSize < prevSize) {
                prevSize = currentSize;
                rankIndex--;
            }
            if (rankIndex < 1) {
                break;
            }
            occurrences.add(new AbstractMap.SimpleEntry<>(sortedEntries.get(i).getKey(), currentSize));
        }
        return occurrences;
    }
}

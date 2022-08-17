package com.cgi.boat.interview.ranking;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class SortingBasedRankingStrategy implements RankingStrategy {

    @Override
    public List<Map.Entry<String, Integer>> apply(int ranks, Map<String, List<String>> nameMapping) {
        List<Map.Entry<String, List<String>>> sortedEntries = sortEntriesByListSizes(nameMapping);
        return applySpecific(ranks, sortedEntries);
    }

    protected abstract List<Map.Entry<String, Integer>> applySpecific(int ranks, List<Map.Entry<String, List<String>>> sortedEntries);

    private List<Map.Entry<String, List<String>>> sortEntriesByListSizes(Map<String, List<String>> nameMapping) {
        return nameMapping.entrySet().stream()
                .sorted((b, a) -> Integer.compare(a.getValue().size(), b.getValue().size())) // descending order
                .collect(Collectors.toList());
    }

}

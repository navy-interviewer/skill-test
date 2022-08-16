package com.cgi.boat.interview.ranking;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface RankingStrategy {
    List<Map.Entry<String, Integer>> apply(int ranks, Map<String, List<String>> nameMapping);

    default List<Map.Entry<String, List<String>>> sortEntriesByListSizes(Map<String, List<String>> nameMapping) {
        return nameMapping.entrySet().stream()
                .sorted((b, a) -> Integer.compare(a.getValue().size(), b.getValue().size())) // descending order
                .collect(Collectors.toList());
    }
}

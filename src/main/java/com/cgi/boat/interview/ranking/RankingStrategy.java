package com.cgi.boat.interview.ranking;

import java.util.List;
import java.util.Map;

public interface RankingStrategy {
    void apply(int ranks, List<Map.Entry<String, Integer>> occurrences, List<Map.Entry<String, List<String>>> sortedEntries);
}

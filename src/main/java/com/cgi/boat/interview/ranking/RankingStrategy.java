package com.cgi.boat.interview.ranking;

import java.util.List;
import java.util.Map;

public interface RankingStrategy {
    List<Map.Entry<String, Integer>> apply(int ranks, Map<String, List<String>> nameMapping);
}

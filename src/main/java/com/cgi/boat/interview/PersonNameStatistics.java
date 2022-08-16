package com.cgi.boat.interview;

import com.cgi.boat.interview.ranking.RankingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonNameStatistics {

    private final RankingStrategy rankingStrategy;

    public PersonNameStatistics(RankingStrategy rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
    }

    public List<Map.Entry<String, Integer>> popularity(Map<String, List<String>> nameMapping, int ranks) {
        final List<Map.Entry<String, Integer>> occurrences = new ArrayList<>();
        checkRanksValidity(ranks);
        if (mappingNotEmpty(nameMapping)) {
            List<Map.Entry<String, List<String>>> sortedEntries = getSortedEntries(nameMapping);
            // different strategies here
            rankingStrategy.apply(ranks, occurrences, sortedEntries);
        }
        return occurrences;
    }

    private void checkRanksValidity(int ranks) {
        if (ranks < 1) {
            throw new IllegalArgumentException("Ranks should be greater or equal to one.");
        }
    }

    private List<Map.Entry<String, List<String>>> getSortedEntries(Map<String, List<String>> nameMapping) {
        return nameMapping.entrySet().stream()
                .sorted((b, a) -> Integer.compare(a.getValue().size(), b.getValue().size())) // descending order
                .collect(Collectors.toList());
    }

    private boolean mappingNotEmpty(Map<String, List<String>> nameMapping) {
        return nameMapping != null && nameMapping.entrySet().size() > 0;
    }

}

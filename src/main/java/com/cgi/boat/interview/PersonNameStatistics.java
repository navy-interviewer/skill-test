package com.cgi.boat.interview;

import com.cgi.boat.interview.ranking.RankingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonNameStatistics {

    private final RankingStrategy rankingStrategy;

    public PersonNameStatistics(RankingStrategy rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
    }

    public List<Map.Entry<String, Integer>> popularity(Map<String, List<String>> nameMapping, int ranks) {
        if (validRanks(ranks) && validMapping(nameMapping)) {
            return rankingStrategy.apply(ranks, nameMapping);
        }
        return new ArrayList<>();
    }

    private boolean validRanks(int ranks) {
        return ranks > 0;
    }

//    private List<Map.Entry<String, List<String>>> entriesSortedByListSize(Map<String, List<String>> nameMapping) {
//        return nameMapping.entrySet().stream()
//                .sorted((b, a) -> Integer.compare(a.getValue().size(), b.getValue().size())) // descending order
//                .collect(Collectors.toList());
//    }

    private boolean validMapping(Map<String, List<String>> nameMapping) {
        return nameMapping != null && nameMapping.entrySet().size() > 0;
    }

}

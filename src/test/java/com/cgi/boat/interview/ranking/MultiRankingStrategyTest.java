package com.cgi.boat.interview.ranking;

import org.junit.jupiter.api.*;

import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MultiRankingStrategyTest {

    RankingStrategy rankingStrategy = new MultiRankingStrategy();
    Map<String, List<String>> map = new HashMap<>();

    @BeforeAll
    void setup() {
        map.put("Jones", Arrays.asList("Berry", "Clifton", "Len"));
        map.put("Jack", Arrays.asList("Tom", "Tim", "Joe"));
        map.put("Smith", Arrays.asList("Kevin", "John", "Robert", "Peter"));
        map.put("Bond", Collections.singletonList("James"));
        map.put("Lee", Arrays.asList("Jason", "Frank"));
    }

    @Test
    void apply_mostFrequent() {
        List<Map.Entry<String, Integer>> ranking = rankingStrategy.apply(1, map);
        Assertions.assertEquals(1, ranking.size());
        Assertions.assertEquals("Smith", ranking.get(0).getKey());
        Assertions.assertEquals(4, ranking.get(0).getValue());
    }

    @Test
    void apply_third() {
        List<Map.Entry<String, Integer>> ranking = rankingStrategy.apply(3, map);
        Assertions.assertEquals(4, ranking.size());
        Assertions.assertEquals("Lee", ranking.get(3).getKey());
        Assertions.assertEquals(2, ranking.get(3).getValue());
    }

    @Test
    void apply_first_and_second() {
        List<Map.Entry<String, Integer>> ranking = rankingStrategy.apply(2, map);
        Assertions.assertEquals(3, ranking.size());
        Assertions.assertEquals(3, ranking.get(1).getValue());
    }
}
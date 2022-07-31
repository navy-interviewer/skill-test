package com.cgi.boat.interview;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxOccurrenceCollectorTest {

    private static final String FIRSTNAME = "Foo";

    private static final String LASTNAME = "Bar";

    private static int RESULT_LIMIT = 3;

    private final Map<String, List<String>> mappedNames = new HashMap<>();

    @Before
    public void init() {
        for (int i = 0; i < 20; i++) {
            List<String> lastNameList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                lastNameList.add(LASTNAME + j);
            }
            mappedNames.put(FIRSTNAME + i, lastNameList);
        }
    }

    @Test
    public void testEmptyArgument() {
        List<AbstractMap.SimpleEntry<String, Integer>> result = MaxOccurrenceCollector.solutionB(Collections.emptyMap(), RESULT_LIMIT);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testLimitZero() {
        Map<String, List<String>> mappedNames = new HashMap<>();
        mappedNames.put(FIRSTNAME, Collections.singletonList(LASTNAME));
        mappedNames.put(FIRSTNAME + "1", Arrays.asList(LASTNAME, LASTNAME + "1"));
        List<AbstractMap.SimpleEntry<String, Integer>> result = MaxOccurrenceCollector.solutionB(Collections.emptyMap(), 0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testLimit() {
        List<AbstractMap.SimpleEntry<String, Integer>> result = MaxOccurrenceCollector.solutionB(mappedNames, RESULT_LIMIT);

        List<AbstractMap.SimpleEntry<String, Integer>> expectedResult = Arrays.asList(
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "19", 19),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "18", 18),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "17", 17)
        );

        assertEquals(RESULT_LIMIT, result.size());
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTwoFirstnameWithSameOccurrence() {
        mappedNames.put(FIRSTNAME + "20", mappedNames.get(FIRSTNAME + "19"));
        mappedNames.put(FIRSTNAME + "21", mappedNames.get(FIRSTNAME + "18"));

        List<AbstractMap.SimpleEntry<String, Integer>> result = MaxOccurrenceCollector.solutionB(mappedNames, RESULT_LIMIT);

        List<AbstractMap.SimpleEntry<String, Integer>> expectedResult = Arrays.asList(
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "19", 19),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "20", 19),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "18", 18),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "21", 18),
                new AbstractMap.SimpleEntry<>(FIRSTNAME + "17", 17)
        );

        assertEquals(5, result.size());
        assertEquals(expectedResult, result);
    }

}

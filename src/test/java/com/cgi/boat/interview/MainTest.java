package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void getTop3OccurrencesShouldReturnBackTheTop3() {
        Map<String, List<String>> firstNameGroups = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        Map<String, List<String>> result = Main.getTopOccurrences(firstNameGroups, 3);

        assertEquals(3, result.size());
        assertEquals(23, result.get("John").size());
        assertEquals(14, result.get("Peter").size());
        assertEquals(13, result.get("David").size());
    }

    @Test
    void getTopNOccurrencesShouldHandleNulls() {
        Map<String, List<String>> testGroups = singletonMap("key", null);

        Map<String, List<String>> result = Main.getTopOccurrences(testGroups, 3);

        assertEquals(0, result.size());
    }
}

package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test_getTopCounts() {
        Map<String, List<String>> names = new HashMap<>();
        names.put("John", Arrays.asList("Doe", "Silver", "Gold"));
        names.put("Peter", Arrays.asList("Doe", "Bronze"));
        names.put("Carol", Arrays.asList("Gold"));

        List<Map.Entry<String, List<String>>> topNames = Main.getTopNames(names, 2);
        assertEquals(2, topNames.size());
        assertEquals("John", topNames.get(0).getKey());
        assertEquals("Peter", topNames.get(1).getKey());
    }

    @Test
    public void test_getTopCounts_countGreaterThanSize() {
        Map<String, List<String>> names = new HashMap<>();
        names.put("John", Arrays.asList("Doe", "Silver", "Gold"));

        List<Map.Entry<String, List<String>>> topNames = Main.getTopNames(names, 3);
        assertEquals(1, topNames.size());
    }

    @Test
    public void test_getTopCounts_draw() {
        Map<String, List<String>> names = new HashMap<>();
        names.put("John", Arrays.asList("Doe", "Silver", "Gold"));
        names.put("Peter", Arrays.asList("Doe", "Bronze"));
        names.put("Carol", Arrays.asList("Gold"));
        names.put("Agnes", Arrays.asList("Long", "Short"));

        List<Map.Entry<String, List<String>>> topNames = Main.getTopNames(names, 2);
        assertEquals(3, topNames.size());
        assertEquals("John", topNames.get(0).getKey());
        assertEquals("Agnes", topNames.get(1).getKey());
        assertEquals("Peter", topNames.get(2).getKey());
    }
}

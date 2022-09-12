package com.cgi.boat.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

	private Map<String, List<String>> firstByLast;
	
	@BeforeEach
	public void setUp() {
		this.firstByLast = Map.of("John", List.of("Doe", "Silver"),
				"Bob", List.of("Retford", "Marley", "Seger"),
				"Jane", List.of("Fonda", "Austen", "Goddal", "Eyre"),
				"Will", List.of("Smith"));
	}
	
	@Test
	public void testFindingTop3() {
		// GIVEN
		List<Entry<String, Integer>> expected = List.of(new SimpleEntry<>("Jane", 4),
				new SimpleEntry<>("Bob", 3),
				new SimpleEntry<>("John", 2));
		
		// WHEN
		List<Map.Entry<String, Integer>> top3 = Main.findMostFrequent(firstByLast, 3);
		
		// THEN
		assertEquals(expected, top3);
	}
	
	@Test
	public void testFindingTop1() {
		// GIVEN
		List<Entry<String, Integer>> expected = List.of(new SimpleEntry<>("Jane", 4));
		
		// WHEN
		List<Map.Entry<String, Integer>> top3 = Main.findMostFrequent(firstByLast, 1);
		
		// THEN
		assertEquals(expected, top3);
	}
}

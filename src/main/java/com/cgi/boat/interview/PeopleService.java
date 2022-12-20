package com.cgi.boat.interview;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleService {

	private static PeopleService instance = null;

	private PeopleService() {
	}

	public static PeopleService getInstance() {
		if (instance == null) {
			instance = new PeopleService();
		}

		return instance;
	}

	// @formatter:off
	public Map<String, Integer> mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurences(Map<String, List<String>> namesByNameMap, int numberOfRequestedResults) {
		return namesByNameMap.entrySet()
				.stream()
				.sorted((left, right) -> Integer.compare(right.getValue().size(), left.getValue().size()))
				.limit(numberOfRequestedResults)
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size(), (left, right) -> left, LinkedHashMap::new));
	}
	// @formatter:on

}

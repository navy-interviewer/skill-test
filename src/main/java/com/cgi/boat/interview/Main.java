package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
		Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

		printMostOccurencedNames(firstByLast, 3);
	}

	// @formatter:off
	private static void printMostOccurencedNames(Map<String, List<String>> namesMap, int numberOfRequestedResults) {
		PeopleService.getInstance().mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurences(namesMap, numberOfRequestedResults)
		.entrySet()
		.forEach(entry -> System.out.println(String.format("%s = %d", entry.getKey(), entry.getValue())));
	}
	// @formatter:on

}

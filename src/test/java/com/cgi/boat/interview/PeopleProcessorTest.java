package com.cgi.boat.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class PeopleProcessorTest {

	// @formatter:off
	@Test
	void testFirstnamesByLastname() {
		Map<String, List<String>> peopleMap = PeopleProcessor.firstnamesByLastname(TestConstants.PERSONS_LIST);

		assertEquals(6, peopleMap.size(), "Not the expected number of distinct lastnames exists in the test data.");
		assertEquals(1, peopleMap.get(TestConstants.LAST_NAME_BAR).size());
		assertEquals(1, peopleMap.get(TestConstants.LAST_NAME_BOARDMAN).size());
		assertEquals(2, peopleMap.get(TestConstants.LAST_NAME_BOOTH).size());
		assertEquals(1, peopleMap.get(TestConstants.LAST_NAME_BOWEN).size());
		assertEquals(3, peopleMap.get(TestConstants.LAST_NAME_DOE).size());
		assertEquals(1, peopleMap.get(TestConstants.LAST_NAME_FOE).size());
	}
	// @formatter:on

	// @formatter:off
	@Test
	void testLastnamesByFirstname() {
		Map<String, List<String>> peopleMap = PeopleProcessor.lastnamesByFirstname(TestConstants.PERSONS_LIST);

		assertEquals(6, peopleMap.size(), "Not the expected number of distinct firstnames exists in the test data.");
		assertEquals(1, peopleMap.get(TestConstants.FIRST_NAME_BOB).size());
		assertEquals(1, peopleMap.get(TestConstants.FIRST_NAME_DONALD).size());
		assertEquals(1, peopleMap.get(TestConstants.FIRST_NAME_JACK).size());
		assertEquals(4, peopleMap.get(TestConstants.FIRST_NAME_JOHN).size());
		assertEquals(1, peopleMap.get(TestConstants.FIRST_NAME_MICHAEL).size());
		assertEquals(1, peopleMap.get(TestConstants.FIRST_NAME_THOMAS).size());
	}
	// @formatter:on

}

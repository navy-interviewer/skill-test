package com.cgi.boat.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PeopleServiceTest {

	// @formatter:off
	@Test
	void mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurencesTest_PeopleProcessorLastnamesByFirstname() {
		try (MockedStatic<PeopleProcessor> mocked = Mockito.mockStatic(PeopleProcessor.class)) {
			mocked.when(() -> PeopleProcessor.lastnamesByFirstname(anyList())).thenReturn(TestConstants.LAST_NAMES_BY_FIRST_NAME_PEOPLE_PROCESSOR_RESULT_MAP);
		}


		int limit = 3;

		Map<String, Integer> resultMap = PeopleService.getInstance()
				.mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurences(
						PeopleProcessor.lastnamesByFirstname(TestConstants.PERSONS_LIST), limit);

		assertEquals(limit, resultMap.size());
		if (limit > 0) {
			assertEquals(4, resultMap.get(TestConstants.FIRST_NAME_JOHN));
		}
	}
	// @formatter:on

	// @formatter:off
	@Test
	void mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurencesTest_PeopleProcessorFirstnamesByLastname() {
		try (MockedStatic<PeopleProcessor> mocked = Mockito.mockStatic(PeopleProcessor.class)) {
			mocked.when(() -> PeopleProcessor.firstnamesByLastname(anyList())).thenReturn(TestConstants.FIRST_NAMES_BY_LAST_NAME_PEOPLE_PROCESSOR_RESULT_MAP);
		}


		int limit = 3;

		Map<String, Integer> resultMap = PeopleService.getInstance()
				.mapToReverseSortedWithGivenNumberOfResultsNameAndNumberOfOccurences(
						PeopleProcessor.firstnamesByLastname(TestConstants.PERSONS_LIST), limit);

		assertEquals(limit, resultMap.size());

		if (limit > 0) {
			assertEquals(3, resultMap.get(TestConstants.LAST_NAME_DOE));
		}
	}
}

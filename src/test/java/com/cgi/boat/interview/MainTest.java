package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    public void testFindFirstThree() {
        //given
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        //when
        List<Result> mostCommonFirstNames = Main.findFirstThree(firstByLast, 3);
        //then
        assert mostCommonFirstNames.size() == 3;
    }
}

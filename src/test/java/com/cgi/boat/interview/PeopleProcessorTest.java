package com.cgi.boat.interview;

import com.cgi.boat.interview.PeopleProcessor;
import com.cgi.boat.interview.PeopleSetup;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class PeopleProcessorTest {

    @Test
    public void testFirstnamesByLastname() {
        //given
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        //when
        //then
        assert firstByLast.get("Smith").size() > 0;
    }

    @Test
    public void testLastnamesByFirstname() {
        // given
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        //when
        //then
        assert lastByFirst.get("John").size() > 0;
    }




}

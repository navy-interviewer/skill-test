package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

class PeopleProcessorTest {

    @Test
    void lastnamesByFirstname() {
    }

    // firstnamesByLastname

    @Test
    void firstnamesByLastname_input_is_null() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(null);
        Assertions.assertEquals(map.keySet().size(), 0);
    }

    @Test
    void firstnamesByLastname_input_is_empty_list() {
        Map<String, List<String>> map = PeopleProcessor.firstnamesByLastname(Collections.emptyList());
        Assertions.assertEquals(map.keySet().size(), 0);
    }

}
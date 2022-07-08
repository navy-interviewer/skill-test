package com.cgi.boat.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PeopleProcessorTest {
    @Test
    public void firstnamesByLastnameEmpty() {
        Map<String, List<String>> res = PeopleProcessor.firstnamesByLastname(new ArrayList<>());
        Assert.assertEquals(res.size(), 0);
    }

    @Test
    public void firstnamesByLastnameOneElement() {
        Map<String, List<String>> res = PeopleProcessor.firstnamesByLastname(Collections.singletonList(new Person("first", "last")));
        Assert.assertEquals(res.size(), 1);
        List<String> last = res.get("last");
        Assert.assertNotNull(last);
        Assert.assertEquals(last.size(), 1);
        Assert.assertEquals(last.get(0), "first");
    }

    @Test
    public void firstnamesByLastnameMoreElement() {
        Map<String, List<String>> res = PeopleProcessor.firstnamesByLastname(Arrays.asList(new Person("first", "last"),
                new Person("2first", "2last")));
        Assert.assertEquals(res.size(), 2);
        List<String> last = res.get("2last");
        Assert.assertNotNull(last);
        Assert.assertEquals(last.size(), 1);
        Assert.assertEquals(last.get(0), "2first");
    }

    @Test
    public void firstnamesByLastnameMoreSameFirstname() {
        Map<String, List<String>> res = PeopleProcessor.firstnamesByLastname(Arrays.asList(new Person("first", "last"),
                new Person("2first", "last")));
        Assert.assertEquals(res.size(), 1);
        List<String> last = res.get("last");
        Assert.assertNotNull(last);
        Assert.assertEquals(last.size(), 2);
        Assert.assertTrue(last.contains("first"));
        Assert.assertTrue(last.contains("2first"));
    }


    @Test
    public void lastnamesByFirstnameEmpty() {
        Map<String, List<String>> res = PeopleProcessor.lastnamesByFirstname(new ArrayList<>());
        Assert.assertEquals(res.size(), 0);
    }

    @Test
    public void lastnamesByFirstnameOneElement() {
        Map<String, List<String>> res = PeopleProcessor.lastnamesByFirstname(Collections.singletonList(new Person("first", "last")));
        Assert.assertEquals(res.size(), 1);
        List<String> first = res.get("first");
        Assert.assertNotNull(first);
        Assert.assertEquals(first.size(), 1);
        Assert.assertEquals(first.get(0), "last");
    }

    @Test
    public void lastnamesByFirstnameMoreElement() {
        Map<String, List<String>> res = PeopleProcessor.lastnamesByFirstname(Arrays.asList(new Person("first", "last"),
                new Person("2first", "2last")));
        Assert.assertEquals(res.size(), 2);
        List<String> first = res.get("2first");
        Assert.assertNotNull(first);
        Assert.assertEquals(first.size(), 1);
        Assert.assertEquals(first.get(0), "2last");
    }

    @Test
    public void lastnamesByFirstnameMoreSameFirstname() {
        Map<String, List<String>> res = PeopleProcessor.lastnamesByFirstname(Arrays.asList(new Person("first", "last"),
                new Person("first", "2last")));
        Assert.assertEquals(res.size(), 1);
        List<String> first = res.get("first");
        Assert.assertNotNull(first);
        Assert.assertEquals(first.size(), 2);
        Assert.assertTrue(first.contains("last"));
        Assert.assertTrue(first.contains("2last"));
    }
}

package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PeopleProcessorTest {

    @Test
    public void lastnamesByFirstname() {
        List<Person> inputList = new LinkedList<>();
        inputList.add(new Person("John", "Doe"));
        inputList.add(new Person("Kate", "Hudson"));
        inputList.add(new Person("Brad", "Pitt"));
        inputList.add(new Person("John", "Smith"));
        inputList.add(new Person("John", "Clooney"));

        Map<String, List<String>> expectedResult = new HashMap<>();
        expectedResult.put("John", List.of("Doe", "Smith", "Clooney"));
        expectedResult.put("Kate", List.of("Hudson"));
        expectedResult.put("Brad", List.of("Pitt"));

        Map<String, List<String>> actualResult = PeopleProcessor.lastnamesByFirstname(inputList);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstnamesByLastname() {
        List<Person> inputList = new LinkedList<>();
        inputList.add(new Person("Greg", "Smith"));
        inputList.add(new Person("Kate", "Smith"));
        inputList.add(new Person("Brad", "Pitt"));
        inputList.add(new Person("Jack", "Smith"));
        inputList.add(new Person("John", "Clooney"));

        Map<String, List<String>> expectedResult = new HashMap<>();
        expectedResult.put("Smith", List.of("Greg", "Kate", "Jack"));
        expectedResult.put("Pitt", List.of("Brad"));
        expectedResult.put("Clooney", List.of("John"));

        Map<String, List<String>> actualResult = PeopleProcessor.firstnamesByLastname(inputList);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void firstnamesByLastname_throwsNullPointer_whenInputNull() {
        PeopleProcessor.firstnamesByLastname(null);
    }

    @Test(expected = NullPointerException.class)
    public void firstnamesByLastname_throwsNullPointer_whenInputEmpty() {
        PeopleProcessor.firstnamesByLastname(new ArrayList<>());
    }

    @Test
    public void getKeysWithNumberOfOccurences() {
        Map<String, List<String>> inputMap = new HashMap<>();
        inputMap.put("John", List.of("Bond", "Doe", "Smith", "Pitt"));
        inputMap.put("Greg", List.of("Bond", "Doe", "Smith"));
        inputMap.put("Simon", List.of("Bond"));

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("John", 4);
        expectedResult.put("Greg", 3);
        expectedResult.put("Simon", 1);

        Map<String, Integer> actualResult = PeopleProcessor.getKeysWithNumberOfOccurences(inputMap);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstN() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("John", 4);
        inputMap.put("Greg", 3);
        inputMap.put("Simon", 1);

        List<String> expectedResult = new LinkedList<>();
        expectedResult.add("John: 4");

        List<String> actualResult = PeopleProcessor.firstN(inputMap, 1);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstN_whenMultipleSameOccurences_latestAddedIsGivenBack() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("John", 4);
        inputMap.put("Greg", 4);
        inputMap.put("Simon", 1);

        List<String> expectedResult = new LinkedList<>();
        expectedResult.add("Greg: 4");

        List<String> actualResult = PeopleProcessor.firstN(inputMap, 1);

        Assert.assertEquals(expectedResult, actualResult);
    }
}

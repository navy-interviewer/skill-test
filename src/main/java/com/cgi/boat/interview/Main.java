package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

import static com.cgi.boat.interview.PeopleProcessor.*;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = lastnamesByFirstname(PeopleSetup.people);

        printResults(firstN(getKeysWithNumberOfOccurences(firstByLast), 3));

        // just because I am interested in it, print by lastname
        System.out.println("--------");
        printResults(firstN(getKeysWithNumberOfOccurences(lastByFirst), 3));
    }

    static void printResults(List<String> stringList) {
        for (String current : stringList) {
            System.out.println(current);
        }
    }
}

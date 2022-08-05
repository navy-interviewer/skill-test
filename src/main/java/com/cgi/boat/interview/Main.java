package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

import static com.cgi.boat.interview.PeopleProcessor.displayTopThreeMostOccurrencesFirstNames;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        System.out.println("Hello CGI Interview not World!");

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        displayTopThreeMostOccurrencesFirstNames(
                PeopleProcessor.orderingByOccurrence(
                        PeopleProcessor.mappingByOccurrence(PeopleSetup.people)));

    }







}

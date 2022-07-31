package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    private static final int PRINT_LIMIT = 5;

    public static void main(String[] args) {
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        MaxOccurrenceCollector.solutionB(lastByFirst, PRINT_LIMIT).forEach(stringIntegerSimpleEntry ->
                System.out.println(String.format("%s: %s", stringIntegerSimpleEntry.getKey(), stringIntegerSimpleEntry.getValue()))
        );
    }


}

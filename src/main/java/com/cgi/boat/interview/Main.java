package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        String sortedLastByFirst = lastByFirst.entrySet().stream()
                .sorted((e1, e2) -> {
                    int s1 = e1.getValue().size();
                    int s2 = e2.getValue().size();
                    int ret = -1;
                    if (s1 < s2) {
                        ret = 1;
                    } else if (s1 == s2) {
                        ret = 0;
                    }
                    return ret;
                })
                .limit(3)
                .map(e -> String.format("%s: %s", e.getKey(),  e.getValue().size()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(sortedLastByFirst);

    }
}

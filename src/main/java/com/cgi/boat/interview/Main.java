package com.cgi.boat.interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);


        List<Result> mostCommonFirstNames = findFirstThree(firstByLast, 3);

        mostCommonFirstNames.forEach((y) -> System.out.printf("%s: %d %n", y.getValue(), y.getCount()));

    }

    /**
     * Returns a list of the most common names by their occurrence in the map
     * @param limit the number of names to return
     * @param names a map of name with correlation to their other given name (interchangeable(first/last))
     * @return a {@link Result} list of the three most common names
     */
    private static List<Result> findFirstThree(Map<String, List<String>> names, int limit) {
        return names.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(e -> new Result.Builder().value(e.getKey()).count(e.getValue().intValue()).build())
                .collect(Collectors.toList());
    }






}

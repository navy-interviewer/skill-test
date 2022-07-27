package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.Collections.reverse;
import static java.util.Comparator.comparingInt;

public class PeopleFinder {

    public static List<PersonListDto> findTheMostFrequentFirstNames(Map<String, List<String>> mapByFirstName, int number) {
        List<PersonListDto> report = new ArrayList<>();
        if (mapByFirstName == null || mapByFirstName.isEmpty() || number <= 0) {
            return report;
        }

        PriorityQueue<PersonListDto> heap = new PriorityQueue<>(comparingInt(PersonListDto::getFrequency));
        for (String firstName : mapByFirstName.keySet()) {
            if (heap.size() < number) {
                heap.offer(new PersonListDto(firstName, mapByFirstName.get(firstName).size()));
            } else if (mapByFirstName.get(firstName).size() > heap.peek().getFrequency()) {
                heap.poll();
                heap.offer(new PersonListDto(firstName, mapByFirstName.get(firstName).size()));
            }
        }

        while (!heap.isEmpty()) {
            report.add(heap.poll());
        }
        reverse(report);

        return report;
    }

}

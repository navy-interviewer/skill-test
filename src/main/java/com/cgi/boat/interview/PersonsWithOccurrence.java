package com.cgi.boat.interview;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonsWithOccurrence implements Comparable<PersonsWithOccurrence>{

    private final Integer occurrence;
    private final List<String> names;

    @Override
    public int compareTo(PersonsWithOccurrence o) {
        return o.occurrence.compareTo(this.occurrence);
    }

    @Override
    public String toString() {
        return "----" + occurrence + ": \n" + String.join(",\n", names);
    }
}

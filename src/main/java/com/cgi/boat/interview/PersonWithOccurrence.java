package com.cgi.boat.interview;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonWithOccurrence implements Comparable<PersonWithOccurrence>{
    private final String name;
    private final Integer occurrence;

    @Override
    public int compareTo(PersonWithOccurrence o) {
        return o.occurrence.compareTo(this.occurrence);
    }

    @Override
    public String toString() {
        return name + ": " + occurrence;
    }
}

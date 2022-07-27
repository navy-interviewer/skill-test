package com.cgi.boat.interview;

public class PersonListDto {

    private final String name;
    private final int frequency;

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public PersonListDto(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

}

package com.cgi.boat.interview;

public class Main {

    public static final int LIMIT = 3;
    public static final String FORMAT = "%s: %d%n";

    public static void main(String[] args) {
        var lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        PeopleProcessor.findMostCommonNames(lastByFirst, LIMIT)
                .forEach(name -> System.out.printf(FORMAT, name.getKey(), name.getValue().size()));
    }

}

package com.cgi.boat.interview;

public class Main {

    public static void main(String[] args) {
        PeopleProcessor.lastnamesByFirstname(PeopleSetup.people).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().size()));
    }


}

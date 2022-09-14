package com.cgi.boat.interview;

import java.util.List;

/**
 * Test fixture with a subset of {@link PeopleSetup#people}
 */
class TestNamesFixture {

    public static final String JOHN = "John";
    public static final String DOE = "Doe";
    public static final String SILVER = "Silver";
    public static final String PETER = "Peter";
    public static final String ACHESON = "Acheson";
    public static final String ARNE = "Arne";
    public static final String JIM = "Jim";
    public static final String BYWATER = "Bywater";
    public static final String EARL = "Earl";

    public final static List<Person> PEOPLE2 = List.of(
            new Person(JOHN, DOE),
            new Person(JOHN, SILVER),
            new Person(JOHN, ACHESON),
            new Person(PETER, ARNE),
            new Person(PETER, BYWATER),
            new Person(PETER, DOE),
            new Person(JIM, BYWATER),
            new Person(EARL, DOE)
    );

    public final static List<Person> PEOPLE1 = List.of(
            new Person(JOHN, DOE),
            new Person(JOHN, SILVER),
            new Person(PETER, DOE)
    );

    private TestNamesFixture() {
    }
}

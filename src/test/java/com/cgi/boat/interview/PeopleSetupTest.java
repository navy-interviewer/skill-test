package com.cgi.boat.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PeopleSetupTest {

    final static List<Person> people = Collections.unmodifiableList(Arrays.asList(
            new Person("John","Acheson"),
            new Person("John","Blundell"),
            new Person("John","Bluthal"),
            new Person("Lee","Boardman"),
            new Person("Lee","Evans"),
            new Person("Roy","Evans"),
            new Person("Evans","Tenniel"),
            new Person("Peter","Zander")
    ));
}

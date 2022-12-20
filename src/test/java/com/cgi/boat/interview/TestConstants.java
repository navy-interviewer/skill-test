package com.cgi.boat.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConstants {

	public static final String FIRST_NAME_JOHN = "John";
	public static final String FIRST_NAME_BOB = "Bob";
	public static final String FIRST_NAME_JACK = "Jack";
	public static final String FIRST_NAME_MICHAEL = "Michael";
	public static final String FIRST_NAME_THOMAS = "Thomas";
	public static final String FIRST_NAME_DONALD = "Donald";

	public static final String LAST_NAME_DOE = "Doe";
	public static final String LAST_NAME_BAR = "Bar";
	public static final String LAST_NAME_FOE = "Foe";
	public static final String LAST_NAME_BOARDMAN = "Boardman";
	public static final String LAST_NAME_BOOTH = "Booth";
	public static final String LAST_NAME_BOWEN = "Bowen";

	public static final Person PERSON_JOHN_DOE = new Person(FIRST_NAME_JOHN, LAST_NAME_DOE);
	public static final Person PERSON_JOHN_BAR = new Person(FIRST_NAME_JOHN, LAST_NAME_BAR);
	public static final Person PERSON_JOHN_FOE = new Person(FIRST_NAME_JOHN, LAST_NAME_FOE);
	public static final Person PERSON_BOB_DOE = new Person(FIRST_NAME_BOB, LAST_NAME_DOE);
	public static final Person PERSON_JACK_DOE = new Person(FIRST_NAME_JACK, LAST_NAME_DOE);
	public static final Person PERSON_MICHAEL_BOARDMAN = new Person(FIRST_NAME_MICHAEL, LAST_NAME_BOARDMAN);
	public static final Person PERSON_THOMAS_BOOTH = new Person(FIRST_NAME_THOMAS, LAST_NAME_BOOTH);
	public static final Person PERSON_DONALD_BOOTH = new Person(FIRST_NAME_DONALD, LAST_NAME_BOOTH);
	public static final Person PERSON_JOHN_BOWEN = new Person(FIRST_NAME_JOHN, LAST_NAME_BOWEN);

	// @formatter:off
	public static final List<Person> PERSONS_LIST = Arrays.asList(
															PERSON_JOHN_DOE,
														    PERSON_JOHN_BAR,
														    PERSON_JOHN_FOE,
														    PERSON_BOB_DOE,
														    PERSON_JACK_DOE,
														    PERSON_MICHAEL_BOARDMAN,
														    PERSON_THOMAS_BOOTH,
														    PERSON_DONALD_BOOTH,
													        PERSON_JOHN_BOWEN
														   );

	@SuppressWarnings("serial")
	public static final Map<String, List<String>> LAST_NAMES_BY_FIRST_NAME_PEOPLE_PROCESSOR_RESULT_MAP = new HashMap<String, List<String>>()
	{{
		put(FIRST_NAME_BOB, Arrays.asList(LAST_NAME_DOE));
		put(FIRST_NAME_DONALD, Arrays.asList(LAST_NAME_BOOTH));
		put(FIRST_NAME_JACK, Arrays.asList(LAST_NAME_DOE));
		put(FIRST_NAME_JOHN, Arrays.asList(LAST_NAME_BAR, LAST_NAME_BOWEN, LAST_NAME_DOE, LAST_NAME_FOE));
		put(FIRST_NAME_MICHAEL, Arrays.asList(LAST_NAME_BOARDMAN));
		put(FIRST_NAME_THOMAS, Arrays.asList(LAST_NAME_BOOTH));
    }};

	@SuppressWarnings("serial")
	public static final Map<String, List<String>> FIRST_NAMES_BY_LAST_NAME_PEOPLE_PROCESSOR_RESULT_MAP = new HashMap<String, List<String>>()
	{{
		put(LAST_NAME_BAR, Arrays.asList(FIRST_NAME_JOHN));
		put(LAST_NAME_BOARDMAN, Arrays.asList(FIRST_NAME_MICHAEL));
		put(LAST_NAME_BOOTH, Arrays.asList(FIRST_NAME_DONALD, FIRST_NAME_THOMAS));
		put(LAST_NAME_BOWEN, Arrays.asList(FIRST_NAME_JOHN));
		put(LAST_NAME_DOE, Arrays.asList(FIRST_NAME_BOB, FIRST_NAME_JACK, FIRST_NAME_JOHN));
		put(LAST_NAME_FOE, Arrays.asList(FIRST_NAME_JOHN));
    }};
	// @formatter:on

}

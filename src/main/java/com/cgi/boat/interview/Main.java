package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
		
		firstByLast.entrySet().stream().map(
				(Entry<String, List<String>> entry) ->
						new FirstnameWithCount(
								entry.getKey(),
								entry.getValue().size()))
				.unordered()
				.sorted((FirstnameWithCount a, FirstnameWithCount b) -> b.count - a.count)
				.limit(3)
				.forEach((FirstnameWithCount fnwc) -> System.out.println(fnwc));
		
    }

}

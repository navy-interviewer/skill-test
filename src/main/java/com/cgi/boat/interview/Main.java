package com.cgi.boat.interview;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

	private static final String PERSON_FREQUENCE_FORMAT = "%s: %d";
	
    public static void main(String[] args) {
    	
    	PeopleProcessor peopleProcessor = new PeopleProcessor();
        Map<String, List<String>> firstByLast = peopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = peopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        
        firstByLast.entrySet().stream()
         	.map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().size()))
        	.sorted(new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
					return Integer.compare(entry2.getValue(), entry1.getValue()); 
				}
			}).limit(3L)
        	.forEach(entry -> {
        		System.out.println(String.format(PERSON_FREQUENCE_FORMAT, entry.getKey(), entry.getValue()));
        	});
    }







}

package com.cgi.boat.interview;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

	private static final String PERSON_FREQUENCE_FORMAT = "%s: %d";
	
    public static void main(String[] args) {
    	
    	PeopleProcessor peopleProcessor = new PeopleProcessor();
        Map<String, List<String>> firstByLast = peopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = peopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        
        findMostFrequent(firstByLast, 3).stream()
        	.forEach(entry -> {
        		System.out.println(String.format(PERSON_FREQUENCE_FORMAT, entry.getKey(), entry.getValue()));
        	});
    }

	public static List<Entry<String, Integer>> findMostFrequent(Map<String, List<String>> namesSorted, long n) {
        return namesSorted.entrySet().stream()
     	.map(e -> new SimpleEntry<>(e.getKey(), e.getValue().size()))
    	.sorted(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return Integer.compare(entry2.getValue(), entry1.getValue()); 
			}
		}).limit(n)
    	.collect(Collectors.toList());
	}







}

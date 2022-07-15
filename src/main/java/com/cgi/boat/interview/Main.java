package com.cgi.boat.interview;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);


        List<Map.Entry<String, List<String>> > list = new LinkedList<Map.Entry<String, List<String>> >(firstByLast.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> o1,
                               Map.Entry<String, List<String>> o2)
            {
                Integer value1 = Integer.valueOf(o1.getValue().size());
                Integer value2 = Integer.valueOf(o2.getValue().size());
                return value2.compareTo(value1);
                //return value1 > value2 ? value1 : value2;

            }
        });

        Map<String, List<String>> temp = new LinkedHashMap<String, List<String>>();
        for (Map.Entry<String, List<String>> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        firstByLast = temp;

        int i = 0;
        for(Map.Entry<String, List<String>> firstNameGroups : firstByLast.entrySet()) {
             System.out.println("firstname: " + firstNameGroups.getKey() + ", number of occurrences: " + firstNameGroups.getValue().size());
             i++;
             if(i == 3) {
                 break;
             }
        }

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
    }







}

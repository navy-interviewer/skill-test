package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        getTopNames(lastByFirst, 3).forEach(e ->
            System.out.println(e.getKey() + ": " + e.getValue().size())
        );
    }

    protected static List<Map.Entry<String, List<String>>> getTopNames(Map<String, List<String>> names, int topCount) {
        ArrayList<Map.Entry<String, List<String>>> nameList = new ArrayList<>(names.entrySet());
        nameList.sort(Main::compare);

        ArrayList<Map.Entry<String, List<String>>> topNames = new ArrayList<>();
        int lastSize = -1;
        int index = 0;
        while (index < nameList.size()) {
            if (index < topCount || nameList.get(index).getValue().size() == lastSize) {
                Map.Entry<String, List<String>> entry = nameList.get(index);
                topNames.add(entry);
                lastSize = entry.getValue().size();
            }
            else {
                break;
            }
            index++;
        }

        return topNames;
    }

    private static int compare(Map.Entry<String, List<String>> e1, Map.Entry<String, List<String>> e2) {
        int size1 = e1.getValue().size();
        int size2 = e2.getValue().size();
        int compared = -1 * Integer.compare(size1, size2);
        if (compared == 0) {
            compared = e1.getKey().compareTo(e2.getKey());
        }
        return compared;
    }
}

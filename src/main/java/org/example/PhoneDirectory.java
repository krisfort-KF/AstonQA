package org.example;

import java.util.*;

public class PhoneDirectory {
    private Map<String, Set<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void addPhone(String lastName, String phoneNumber) {

        if (directory.containsKey(lastName)) {
            directory.get(lastName).add(phoneNumber);
        } else {
            Set<String> phones = new HashSet<>();
            phones.add(phoneNumber);
            directory.put(lastName, phones);
        }
    }

    public Set<String> getPhones(String lastName) {
        return directory.getOrDefault(lastName, Collections.emptySet());
    }

    public void printDirectory() {
        directory.forEach((lastName, phones) ->
                System.out.println(lastName + ": " + String.join(", ", phones)));
    }
}

package com.example.constructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = new ArrayList<>();

        for (String name : names) {
            persons.add(new Person(name));
        }
    }
}

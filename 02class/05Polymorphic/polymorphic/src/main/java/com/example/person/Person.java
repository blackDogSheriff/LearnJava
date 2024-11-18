package com.example.person;

public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return this.name.equals(p.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public void run() {
        System.out.println("Person.run()");
    }
}

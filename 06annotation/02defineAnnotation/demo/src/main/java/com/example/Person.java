package com.example;

public class Person {
    @Range(min = 5, max = 10)
    private String name;
    @Range(min = 5, max = 10)
    private String city;

    public Person() {
        this("", "");
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

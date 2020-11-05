package com.training.assignments.polymorphism.overloading;

public class Employee {

    public String getName(String name) {
        return name;
    }

    public String getName(String name, String lastName) {
        return name + " " + lastName;
    }

    public String getName(String name, String lastName, String middleName) {
        return name + " " + lastName + " " + middleName;
    }
}
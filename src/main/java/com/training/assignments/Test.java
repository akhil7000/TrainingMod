package com.training.assignments;

public class Test {
    public String getFullName() {
        Child child = new Child();
        return child.getSurname() + " " + child.getFirstName();
    }
}

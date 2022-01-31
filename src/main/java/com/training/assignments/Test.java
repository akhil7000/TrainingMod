package com.training.assignments;

public class Test {
    public String getFullName() {
        Child child = new Child();
        child.getSurname();
        child.getFirstName();
        return child.getSurname() + " " + child.getFirstName();
    }
}

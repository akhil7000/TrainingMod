package com.training.assignments.inheritance;

public class ParentChild {

    public String  getName() {
        Child child=new Child();
        return child.firstName+" "+child.surname;
    }
}
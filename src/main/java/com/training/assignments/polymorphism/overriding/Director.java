package com.training.assignments.polymorphism.overriding;

public class Director extends Actor{

    @Override
    public String work() {
        String directorWork="Directing";
       return super.actorWork+" "+directorWork;
    }
}
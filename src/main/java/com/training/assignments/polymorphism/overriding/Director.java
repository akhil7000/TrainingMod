package com.training.assignments.polymorphism.overriding;

public class Director extends Actor {

    @Override
    public String getWorkDetail() {
        String directorWork = "Directing";
        return super.actorWork + " " + directorWork;
    }
}
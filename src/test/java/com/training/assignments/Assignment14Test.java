package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment14Test {

    @Test
    public void testMovie() {
        Actor actor=new Director();
        Actor actor1=new Actor();
        Assertions.assertEquals("Doing Directing", actor.getWork(), "he is not directing");
        Assertions.assertEquals("Doing acting",actor1.getWork(),"he is not acting");
    }
}
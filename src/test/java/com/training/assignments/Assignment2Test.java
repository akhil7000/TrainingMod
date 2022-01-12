package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment2Test {
    Assignment2 assignment2 = new Assignment2();

    @Test
    public void string1Test() {
        Assertions.assertEquals("Sam", assignment2.string1("Ram", "Sam"));
    }

    @Test
    public void string2Test() {
        Assertions.assertEquals("Sachin Masterrrr", assignment2.string1("Sachin Tendulkar", "Sachin Masterrrr"));
    }

    @Test
    public void string3Test() {
        Assertions.assertEquals("Depp", assignment2.string1("Dell", "Depp"));
    }
}
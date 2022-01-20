package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment2Test {
    Assignment2 assignment2 = new Assignment2();

    @Test
    public void testStringReplace() {
        Assertions.assertEquals("Sam", assignment2.getStringReplace("Ram", "Sam"));
        Assertions.assertEquals("Sachin Masterrrr", assignment2.getStringReplace("Sachin Tendulkar", "Sachin Masterrrr"));
        Assertions.assertEquals("Depp", assignment2.getStringReplace("Dell", "Depp"));
    }
}
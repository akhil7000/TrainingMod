package com.training.sample.tests;

import com.training.sample.pages.Assignment2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment2Test {
    Assignment2 assignment2 = new Assignment2();

    @Test
    public void testStringReplace() {
        Assertions.assertEquals(new String("Sam"), assignment2.stringReplace("Ram", "Sam"));
        Assertions.assertEquals(
                new String("Sachin Masterrrr"),
                assignment2.stringReplace("Sachin Tendulkar", "Sachin Masterrrr"));
        Assertions.assertEquals("Depp", assignment2.stringReplace("Dell", "Depp"));
    }
}

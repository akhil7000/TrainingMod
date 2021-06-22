package com.training.sample.tests;

import com.training.sample.pages.Assignment2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment2Test {
    Assignment2 assignment2 = new Assignment2();

    @Test
    public void testStringReplace() {
        String oldStr1 = "Sam";
        String oldStr2 = "Sachin Masterrrr";
        String oldStr3 = "Depp";
        Assertions.assertEquals(oldStr1, assignment2.getStringReplace("Ram", oldStr1));
        Assertions.assertEquals(oldStr2, assignment2.getStringReplace("Sachin Tendulkar", oldStr2));
        Assertions.assertEquals(oldStr3, assignment2.getStringReplace("Dell", oldStr3));
    }
}

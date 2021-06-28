package com.training.sample.tests;

import com.training.sample.pages.Assignment3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment3Test {
    Assignment3 assignment3 = new Assignment3();

    @Test
    public void testGetIndex() {
        Assertions.assertEquals(0, assignment3.getIndex("Xioami", "X"));
        Assertions.assertEquals(3, assignment3.getIndex("Xioami", "a"));
        Assertions.assertEquals(2, assignment3.getIndex("Xioami", "o"));
    }
}

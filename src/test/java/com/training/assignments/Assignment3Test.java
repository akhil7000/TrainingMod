package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment3Test {
    Assignment3 assignment3 = new Assignment3();

    @Test
    public void testGetIndex() {
        Assertions.assertEquals(0, assignment3.getIndex("Xioami", "X"));
    }
}
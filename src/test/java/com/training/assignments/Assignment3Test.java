package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment3Test {
    Assignment3 assignment3 = new Assignment3();

    @Test
    public void testGetIndex1() {
        Assertions.assertEquals(0, assignment3.getIndex("Xioami", "X"));
    }

    @Test
    public void testGetIndex2() {
        Assertions.assertEquals(3, assignment3.getIndex("Xioami", "a"));
    }

    @Test
    public void testGetIndex3() {
        Assertions.assertEquals(2, assignment3.getIndex("Xioami", "o"));
    }

}
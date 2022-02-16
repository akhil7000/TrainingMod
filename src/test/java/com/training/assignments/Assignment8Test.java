package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment8Test {
    Assignment8 assignment8 = new Assignment8();

    @Test
    public void testMiddleNumber() {
        Assertions.assertEquals(15, assignment8.getMiddleNumber(10, 20), "This is not a middle number");
    }
}
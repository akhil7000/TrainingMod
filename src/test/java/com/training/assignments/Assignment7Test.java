package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment7Test {
    Assignment7 assignment7 = new Assignment7();

    @Test
    public void testNature() {
        Assertions.assertEquals("Good people should go to heaven", assignment7.getNature("Good"));
    }
}
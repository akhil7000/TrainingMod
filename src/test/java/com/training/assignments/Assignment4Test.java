package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment4Test {

    Assignment4 assignment4 = new Assignment4();

    @Test
    public void testGetSubstring() {
        Assertions.assertEquals("Corporation", assignment4.getSubstring("Indian Oil Corporation Ltd", 11, 22));
    }
}
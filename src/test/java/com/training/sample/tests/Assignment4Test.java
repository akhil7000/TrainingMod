package com.training.sample.tests;

import com.training.sample.pages.Assignment4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment4Test {
    Assignment4 assignment4 = new Assignment4();

    @Test
    public void testGetString() {
        Assertions.assertEquals(
                "Corporation", assignment4.getString("Indian Oil Corporation Ltd", 11, 22));
    }
}

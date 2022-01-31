package com.training.assignments;

import org.junit.jupiter.api.Assertions;

class TestTest {
    Test test = new Test();

    @org.junit.jupiter.api.Test
    public void testGetFullName() {
        Assertions.assertEquals("TYSON MIKE", test.getFullName());
    }
}
package com.training.assignments;

import org.junit.jupiter.api.Assertions;

class TestTest {

    @org.junit.jupiter.api.Test
    public void testGetFullName() {
        Assertions.assertEquals("TYSON MIKE", new Test().getFullName(),"Incorrect name");
    }
}
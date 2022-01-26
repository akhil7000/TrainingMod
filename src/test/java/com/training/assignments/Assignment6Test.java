package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment6Test {

    Assignment6 assignment6 = new Assignment6();

    @Test
    public void testGetReview() {
        Assertions.assertEquals("It is a good company", assignment6.getCompanyName("Google"));
        Assertions.assertEquals("Invalid input", assignment6.getCompanyName("CapeGemini"));
    }
}
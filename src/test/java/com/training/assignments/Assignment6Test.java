package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment6Test {

    Assignment6 assignment6 = new Assignment6();

    @Test
    public void testGetReview() {
        Assertions.assertEquals("It is a good company", assignment6.getCompanyName("Google"));
        Assertions.assertEquals("It is a good company", assignment6.getCompanyName("Amazon"));
        Assertions.assertEquals("It is a bad company", assignment6.getCompanyName("H20"));
        Assertions.assertEquals("It is an average company", assignment6.getCompanyName("flipkart"));
        Assertions.assertEquals("It is a bad company", assignment6.getCompanyName("Tartan"));
        Assertions.assertNotNull(assignment6.getCompanyName("Google"));
    }
}
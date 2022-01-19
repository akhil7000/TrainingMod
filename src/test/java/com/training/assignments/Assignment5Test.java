package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment5Test {
    Assignment5 assignment5 = new Assignment5();

    @Test
    public void testGetIndexArray() {
        String array[] = {"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"};
        Assertions.assertEquals(3, assignment5.getIndexArray(array, "Ronaldo"));
        Assertions.assertEquals(-1, assignment5.getIndexArray(array, "Ron"));
        Assertions.assertNotEquals(8, assignment5.getIndexArray(array, "Ronaldo"));
    }
}



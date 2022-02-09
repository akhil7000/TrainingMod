package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment17Test {

    @Test
    public void testGetSum() {
        Assertions.assertEquals(15, new Yes1().getSum(5), "Wrong addition");
    }
}
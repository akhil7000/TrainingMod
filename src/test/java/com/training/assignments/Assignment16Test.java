package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment16Test {

    @Test
    void testGetSum() {
        Assertions.assertEquals(15,new Yes1().getSum(5),"not correct");
    }
}
package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Assignment10Test {
    Assignment10 assignment10 = new Assignment10();

    @Test
    public void testOddNumber() {
        ArrayList<Integer> numberList = assignment10.getNumbers(1, 10);
        ArrayList<Integer> oddNumberList = assignment10.getOddNumber(numberList);

        for (int oddNumber : oddNumberList) {
            Assertions.assertTrue(oddNumber % 2 != 0, "This is not odd");

        }
    }
}



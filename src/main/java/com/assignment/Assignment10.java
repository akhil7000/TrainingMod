package com.assignment;

import java.util.Arrays;

public class Assignment10 {
    public void odd(int min, int max) {
        int[] intArray = new int[max - min+1];
        for (int i = min; i < max; i++) {
            intArray[i] = i;
            if (i % 2 == 1) {
            System.out.println(i);
            }
        }
    }
}

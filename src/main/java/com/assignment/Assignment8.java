package com.assignment;

public class Assignment8 {

    public int getMiddleNumber(int min, int max) {
        for (int i = min; i <= max; i++) {
            if (i == (max + min) / 2) {
                return i;
            }
        }
        return 0;
    }
}
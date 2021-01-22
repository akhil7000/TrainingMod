package com.assignment;

public class Assignment8 {

    public int getMiddleNumber(int min, int max) {
        for (int index = min; index <= max; index++) {
            if (index == (max + min) / 2) {
                return index;
            }
        }
        return 0;
    }
}
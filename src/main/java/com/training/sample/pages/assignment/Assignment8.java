package com.training.sample.pages.assignment;

public class Assignment8 {

    public int getMiddleNumber(int min, int max) {
        int middleNumber = (max + min) / 2;
        for (int index = min; index <= max; index++) {
            if (index == middleNumber) {
                return index;
            }
        }
        return 0;
    }
}
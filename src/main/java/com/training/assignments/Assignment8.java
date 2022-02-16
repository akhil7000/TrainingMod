package com.training.assignments;

public class Assignment8 {

    public int getMiddleNumber(int startRange, int endRange) {
        int middleNumber = (startRange + endRange) / 2;
        for (int startIndex = startRange; startRange <= endRange; startIndex++) {
            if (startIndex == middleNumber) {
                return startIndex;
            }
        }
        return 0;
    }
}


package com.training.assignments;

import java.util.ArrayList;

public class Assignment10 {

    public ArrayList<Integer> getNumbers(int startRange, int endRange) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int value = startRange; value <= endRange; value++) {
            numbers.add(value);
        }
        return numbers;
    }

    public ArrayList<Integer> getOddNumber(ArrayList<Integer> numbers) {

        ArrayList<Integer> oddList = new ArrayList<>();

        for (int value : numbers) {
            if (value % 2 != 0) {
                oddList.add(value);
            }
        }
        return oddList;
    }
}





package com.assignment;

import java.util.ArrayList;

public class Assignment10 {
    public ArrayList<Integer> getNumbersArray(int min, int max) {
        ArrayList<Integer> numberArray = new ArrayList<>();
        for (int index = min; index <= max; index++) {
            numberArray.add(index);
        }
        return numberArray;
    }

    public ArrayList<Integer> getOddNumbers(ArrayList<Integer> numbersArray) {
        ArrayList<Integer> oddNumberArrayList = new ArrayList<>();
        for (int number : numbersArray) {
            if (number % 2 == 1) {
                oddNumberArrayList.add(number);
            }
        }
        return oddNumberArrayList;
    }
}
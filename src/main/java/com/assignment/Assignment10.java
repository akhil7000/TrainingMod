package com.assignment;

import java.util.ArrayList;

public class Assignment10 {
    public ArrayList getOddNumbers(int min, int max) {

        ArrayList<Integer> oddNumbersArraylist = new ArrayList<>();
        int index=max+min;
        int numberArray[]=new int[index];
        for (int i = min; i <= max; i++) {
            if (i % 2 == 1) {
                oddNumbersArraylist.add(i);
            }
        }
        /*for (int i : numberArray) {
            numberArray[i]=i;
            if (i % 2 == 1) {
                oddNumbersArraylist.add(i);
            }
        }*/
        /*for (index:numberArray) {
            if (index % 2 == 1) {
                oddNumbersArraylist.add(index);
            }
        }*/
        return oddNumbersArraylist;
    }
}
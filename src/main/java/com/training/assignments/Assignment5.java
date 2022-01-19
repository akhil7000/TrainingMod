package com.training.assignments;

public class Assignment5 {
    public int getIndexArray(String[] array, String word) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}


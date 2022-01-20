package com.training.assignments;

public class Assignment5 {
    public int getIndexArray(String[] array, String word) {
        for (int index = 0; index < array.length; index++) {
            if (array[index].equals(word)) {
                return index;
            }
        }
        return -1;
    }
}

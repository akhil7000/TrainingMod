package com.training.assignments;

public class Assignment5 {
    public int getArrayIndex(String[] name, String word) {
        for (int index = 0; index < name.length; index++) {
            if (name[index].equals(word)) {
                return index;
            }
        }
        return -1;
    }
}

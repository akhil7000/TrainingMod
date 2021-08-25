package com.training.sample.pages;

public class Assignment5 {
    public int getStringIndex(String[] names, String word) {
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == word) {
                index = i;
            }
        }
        return index;
    }
}

package com.training.sample.pages;

public class Assignment5 {
    public int getStringIndex(String[] names, String word) throws Exception {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(word)) {
                return i;
            }
        }
        throw new Exception("Element match not found");
    }
}

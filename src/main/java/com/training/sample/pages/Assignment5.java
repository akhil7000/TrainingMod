package com.training.sample.pages;

public class Assignment5 {
    public int getStringIndex(String[] names, String word) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == word) {
                index = i;
            }
            try {
                if (index == -1) throw new Exception();
            } catch (Exception e) {
            }
        }
        return index;
    }
}

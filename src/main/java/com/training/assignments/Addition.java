package com.training.assignments;

interface WillDoEverything {
    public int getSum(int a);
}

public class Addition implements WillDoEverything {

    public int getSum(int a) {
        return (a + a + a);
    }
}
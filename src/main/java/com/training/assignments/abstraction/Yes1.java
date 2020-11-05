package com.training.assignments.abstraction;

public class Yes1 extends WillDoEverything {
    int b = 10;
    int c = 20;
    int x;

    @Override
    public int getSum(int a) {
        return x = a + b + c;
    }
}
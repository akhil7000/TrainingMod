package com.assignment;

abstract class WillDoEverything {
    public abstract int getSum(int a);
}

public class SumMethodClass extends WillDoEverything {
    public int getSum(int a) {
        return a + a + a;
    }
}
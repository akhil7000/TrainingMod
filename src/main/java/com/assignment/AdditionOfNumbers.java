package com.assignment;

abstract class WillDoEverythingg {

    public abstract int getSum(int a);
}

public class AdditionOfNumbers extends WillDoEverythingg {

    public int getSum(int a) {
        return a + a + a;
    }
}
package com.assignment;

abstract class WillDoEverything {
    public abstract int sum(int a);
}

public class Yes1 extends WillDoEverything {
    public int sum(int a) {
        return a + a + a;
    }
}
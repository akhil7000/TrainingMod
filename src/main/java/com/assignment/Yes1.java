package com.assignment;

interface WillDoEverything {
    public int sum(int a);
}

public class Yes1 implements WillDoEverything {

    public int sum(int a) {
        return (a + a + a);
    }
}

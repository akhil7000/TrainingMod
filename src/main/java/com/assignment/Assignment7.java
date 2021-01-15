package com.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment7 {
    public static String whatAreYou(String quality) {
        String a;
        if (quality.equals("very good")) {
            a="Go to heaven with dogs";
        }
        else if (quality.equals("good")) {
            a="Go to heaven";
        }
        else {
            a="Go to hell";
        }
        return a;
    }
}
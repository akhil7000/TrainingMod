package com.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment7 {
    public String return_where_user_will_Go(String quality) {
    if (quality.equals("very good")) {
    return  "Go to heaven with dogs";
    }
    else if (quality.equals("good")) {
    return "Go to heaven";
    }
    else {
    return "Go to hell";
    }
    }
}
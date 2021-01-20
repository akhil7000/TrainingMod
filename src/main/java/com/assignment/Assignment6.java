package com.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment6 {

    public String getCompanyReview(String companyname) {
        switch (companyname) {
            case "Google":
                return "Monitors everything";
            case "Apple":
                return "Costlier than android";
            case "Facebook":
                return "Too much data tracking";
            case "Amazon":
                return "Will sell you anything";
            case "Microsoft":
                return "Nothing free but safer";
            default:
                return "Enter valid name";
        }
    }
}

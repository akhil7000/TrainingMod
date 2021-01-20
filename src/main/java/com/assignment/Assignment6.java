package com.assignment;

public class Assignment6 {

    public String getCompanyReview(String companyName) {
        switch (companyName) {
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

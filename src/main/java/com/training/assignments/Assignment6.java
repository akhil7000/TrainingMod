package com.training.assignments;

public class Assignment6 {
    public String getCompanyName(String companyName) {

        switch (companyName) {
            case "Google":
            case "Amazon":
                return "It is a good company";

            case "H20":
            case "Tartan":
                return "It is a bad company";

            case "flipkart":
                return "It is an average company";

            default:
                return "Invalid input";

        }
    }
}
package com.training.assignments;

public class Assignment6 {
    public String getCompanyName(String companyName) {

        switch (companyName) {
            case "Google":
                return "It is a good company";

            case "Amazon":
                return "It is a good company";

            case "H20":
                return "It is a bad company";

            case "flipkart":
                return "It is an average company";

            case "Tartan":
                return "It is a bad company";

            default:
                return "Invalid input";

        }
    }
}
package com.training.assignments;

public class Assignment15 {
    String firstName = "NA";
    String lastName = "NA";
    String middleName = "NA";

    public String getFullName() {
        return "NA";
    }

    public String getFullName(String firstName) {
        return firstName;
    }

    public String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String getFullName(String firstName, String lastName, String middleName) {
        return firstName + " " + lastName + " " + middleName;
    }
}

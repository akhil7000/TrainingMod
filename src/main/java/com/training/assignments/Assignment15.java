package com.training.assignments;

public class Assignment15 {
    String firstName = "NA";
    String lastName = "NA";
    String middleName = "NA";

    public String getFullName() {
        return getFullName("NA","","");
    }

    public String getFullName(String firstName) {
        return getFullName(firstName,"","");
    }

    public String getFullName(String firstName, String lastName) {
        return getFullName(firstName,lastName,"");
    }

    public String getFullName(String firstName, String lastName, String middleName) {
        return (firstName + " " + lastName + " " + middleName).trim();
    }
}

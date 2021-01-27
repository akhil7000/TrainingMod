package com.assignment;

public class StudentAssignment12 {
    private String name, lastname;
    private int rollno;
    private static String school;

    public static void setSchool(String schoolName){
        school=schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public static String getSchool() {
        return school;
    }
}
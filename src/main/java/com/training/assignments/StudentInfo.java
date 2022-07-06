package com.training.assignments;

public class StudentInfo {
    private int id;
    private String name;
    private String address;
    private int classNo;
    private static String schoolName;

    public StudentInfo(int id, String name, String address, int classNo) {
        this.name=name;
        this.id=id;
        this.address=address;
        this.classNo=classNo;

    }

    public StudentInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        StudentInfo.schoolName = schoolName;
    }

}

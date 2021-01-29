package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentInfo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //ArrayList<Student> studentArL = new ArrayList<>();
    public void setStudentInfo(ArrayList<Student> studentArL, String[] info) {
        Student student = new Student();

        student.setId(info[0]);
        student.setName(info[1]);
        student.setAddress(info[2]);
        student.setStudentClass(info[3]);
        student.setSchool(info[4]);
        studentArL.add(student);
        logger.info("Student information added");
    }

    public void getStudentList(ArrayList<Student> studentArL) {
        if (studentArL.size() != 0) {
            for (int i = 0; i < studentArL.size(); i++) {
                Student student = studentArL.get(i);
                logger.info(student.getId() + " " + student.getName() +
                        " " + student.getAddress() + " " + student.getStudentClass() +
                        " " + student.getSchool());
            }
        } else {
            System.out.println("There is no student information!!!");
        }
    }

    public void getStudentInfo(ArrayList<Student> studentArL, String studentDetails) {
        Student student = new Student();
        for (int i = 0; i < studentArL.size(); i++) {
            student = studentArL.get(i);
            if (student.getId() == studentDetails || student.getName() == studentDetails
                    || student.getAddress() == studentDetails || student.getStudentClass() == studentDetails
                    || student.getSchool() == studentDetails) {
                logger.info(student.getId() + " " + student.getName() + " " + student.getAddress()
                        + " " + student.getStudentClass() + " " + student.getSchool());
            }
        }
    }

    public void setEditStudent(ArrayList<Student> studentArL, String index, String[] info) {
        Student student = new Student();
        for (int i = 0; i < studentArL.size(); i++) {
            Student s = studentArL.get(i);
            if (s.getId() == index || s.getName() == index) {
                student.setId(info[0]);
                student.setName(info[1]);
                student.setAddress(info[2]);
                student.setStudentClass(info[3]);
                student.setSchool(info[4]);
                studentArL.set(i, student);
            }
        }
        logger.info("Student information had been updated");
    }

    public void setDeleteStudent(ArrayList<Student> studentArL, String id) {
        if (studentArL.size() == 0) {
            System.out.println("No Student Data Present");
        } else {
            System.out.println("Enter the student ID");
            for (int i = 0; i < studentArL.size(); i++) {
                Student s = studentArL.get(i);
                if (s.getId().equals(id)) {
                    studentArL.remove(i);
                    System.out.println("Student successfully removed");

                } else {
                    System.out.println("There is no such student, please try again");
                }
            }
        }
    }
}
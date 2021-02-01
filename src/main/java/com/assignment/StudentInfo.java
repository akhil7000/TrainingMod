package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class StudentInfo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ArrayList<Student> studentList = new ArrayList<>();

    public void setStudentInfo(String[] info) {
        Student student = new Student();

        student.setId(info[0]);
        student.setName(info[1]);
        student.setAddress(info[2]);
        student.setStudentClass(info[3]);
        student.setSchool(info[4]);
        studentList.add(student);
        logger.info("Student information added");
    }

    public String[][] getStudentList() {
        Student student;
        String[][] studentArray = new String[studentList.size()][5];
        if (studentList.size() != 0) {
            for (int i = 0; i < studentList.size(); i++) {
                student = studentList.get(i);
                studentArray[i][0] = student.getId();
                studentArray[i][1] = student.getName();
                studentArray[i][2] = student.getAddress();
                studentArray[i][3] = student.getStudentClass();
                studentArray[i][4] = student.getSchool();
                logger.info(student.getId() + " " + student.getName() +
                        " " + student.getAddress() + " " + student.getStudentClass() +
                        " " + student.getSchool());
            }
        } else {
            logger.info("There is no student information");
        }
        return studentArray;
    }

    public Student getStudentInfo(String studentDetails) {
        Student student = null;
        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            student = studentList.get(i);
            if (studentDetails.equals(student.getId()) || studentDetails.equals(student.getName()) ||
                    studentDetails.equals(student.getAddress()) || studentDetails.equals(student.getStudentClass())
                    || studentDetails.equals(student.getSchool())) {
                logger.info(student.getId() + " " + student.getName() + " " + student.getAddress()
                        + " " + student.getStudentClass() + " " + student.getSchool());
                count = 0;
                break;

            } else {
                count = 1;
            }
        }
        if (count == 1) {
            logger.info("No such Student");
        }
        return student;
    }

    public void editStudent(String index, String[] info) {
        Student student = new Student();
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getId() == index || s.getName() == index) {
                student.setId(info[0]);
                student.setName(info[1]);
                student.setAddress(info[2]);
                student.setStudentClass(info[3]);
                student.setSchool(info[4]);
                studentList.set(i, student);
            }
        }
        logger.info("Student information had been updated");
    }

    public void deleteStudent(String id) {
        String returnString = null;
        if (studentList.size() == 0) {
            returnString = ("No Student Data Present");
        } else {
            logger.info("Enter the student ID");
            for (int i = 0; i < studentList.size(); i++) {
                Student s = studentList.get(i);
                if (s.getId().equals(id)) {
                    studentList.remove(i);
                    returnString = ("Student successfully removed");
                    break;
                } else {
                    returnString = "There is no such student, please try again";
                }
            }
        }
        logger.info(returnString);
    }

    public int getListSize() {
        return studentList.size();
    }
}
package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class StudentInfo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ArrayList<Student> studentArrayList = new ArrayList<>();

    public void setStudentInfo(String[] info) {

        Student student = new Student();

        student.setId(info[0]);
        student.setName(info[1]);
        student.setAddress(info[2]);
        student.setStudentClass(info[3]);
        student.setSchool(info[4]);

        studentArrayList.add(student);

        logger.info("Student information added");
    }

    public ArrayList<Student> getStudentList() {

        Student student;
        if (!studentArrayList.isEmpty()) {
            for (int i = 0; i < studentArrayList.size(); i++) {
                student = studentArrayList.get(i);
                logger.info(student.getId() + " " + student.getName() +
                        " " + student.getAddress() + " " + student.getStudentClass() +
                        " " + student.getSchool());
            }
        } else {
            logger.info("There is no student information");
        }
        return studentArrayList;
    }

    public ArrayList<Student> getStudentInfo(String studentKey) {

        Student student;
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < studentArrayList.size(); i++) {
            student = studentArrayList.get(i);
            if (studentKey.equals(student.getId()) || studentKey.equals(student.getName()) ||
                    studentKey.equals(student.getAddress()) || studentKey.equals(student.getStudentClass())
                    || studentKey.equals(student.getSchool())) {
                logger.info(student.getId() + " " + student.getName() + " " + student.getAddress()
                        + " " + student.getStudentClass() + " " + student.getSchool());
                studentList.add(student);
            }
        }
        if (studentList.isEmpty()) {
            logger.info("No such student");
        }
        return studentList;
    }

    public void editStudent(String studentKey, String[] info) {

        Student student = new Student();
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student s = studentArrayList.get(i);
            if (studentKey.equals(s.getId()) || studentKey.equals(s.getName())) {
                student.setId(info[0]);
                student.setName(info[1]);
                student.setAddress(info[2]);
                student.setStudentClass(info[3]);
                student.setSchool(info[4]);
                studentArrayList.set(i, student);
            }
        }
        logger.info("Student information had been updated");
    }

    public void deleteStudent(String studentId) {

        String returnString = null;
        if (studentArrayList.isEmpty()) {
            returnString = ("No Student Data Present");
        } else {
            for (int i = 0; i < studentArrayList.size(); i++) {
                Student s = studentArrayList.get(i);
                if (s.getId().equals(studentId)) {
                    studentArrayList.remove(i);
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

        return studentArrayList.size();
    }
}
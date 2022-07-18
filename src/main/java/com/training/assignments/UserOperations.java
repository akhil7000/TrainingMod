package com.training.assignments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserOperations {
   private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int delete(List<StudentInfo> listStudent, int id) {

        int index = 0;
        try {
            for (StudentInfo studentInfo : listStudent) {
                if (studentInfo.getId() == id) {
                    break;
                }
                index++;

            }
            listStudent.remove(index);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public int updateStudentById(List<StudentInfo> listStudent, int id, String newName, String newAddress, String newSchoolName) {

        for (StudentInfo studentInfo : listStudent) {

            if (studentInfo.getId() == id) {
                logger.info("please enter the name to be updated");
                studentInfo.setName(newName);

                logger.info("please enter the address to be updated");
                studentInfo.setAddress(newAddress);

                logger.info("please enter the school to be updated");
                studentInfo.setSchoolName(newSchoolName);
            }
        }
        return 1;
    }

    public int updateStudentByName(List<StudentInfo> listStudent, String name, int newId, String newAddress, String newSchoolName) {

        for (StudentInfo studentInfo : listStudent) {

            if (studentInfo.getName() == name) {
                logger.info("please enter the id to be updated");
                studentInfo.setId(newId);

                logger.info("please enter the address to be updated");
                studentInfo.setAddress(newAddress);

                logger.info("please enter the school to be updated");
                studentInfo.setSchoolName(newSchoolName);

            }
        }
        return 1;
    }

    public boolean searchStudentsById(List<StudentInfo> listStudent, int id) {
        for (StudentInfo studentInfo : listStudent) {
            if (studentInfo.getId() == id) {
                logger.info("ID: " + studentInfo.getId() + "\t Name: " + studentInfo.getName() + "\t Address: " + studentInfo.getAddress());
                return true;
            }

        }
        return false;
    }

    public boolean searchStudentsByName(List<StudentInfo> listStudent, String name) {
        for (StudentInfo studentInfo : listStudent) {
            if (studentInfo.getName().equals(name)) {
                logger.info("ID: " + studentInfo.getId() + "\t Name: " + studentInfo.getName() + "\t Address: " + studentInfo.getAddress());

                return true;
            }
        }
        return false;
    }

    public void displayStudents(List<StudentInfo> listStudent) {

        if (listStudent.isEmpty()) {
            logger.info("no students");
        } else {
            for (StudentInfo studentInfo : listStudent) {

                logger.info("ID: " + studentInfo.getId() + "\t Name: " + studentInfo.getName() + "\t Address: " + studentInfo.getAddress() + "\t Class no :" + studentInfo.getClassNo() +
                        "\t SchoolName :" + studentInfo.getSchoolName());
            }
        }

    }

    public void insertStudent(List<StudentInfo> listStudent) {

        listStudent.add(new StudentInfo(3, "jack", "ll", 2, "CJCS"));

        logger.info("Student added successfully" + listStudent.toString());
    }
}


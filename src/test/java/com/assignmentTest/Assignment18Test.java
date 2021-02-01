package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment18Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
    String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
    String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
    String[] infoTrump = {"3", "Donald Trump", "Mar-a-lago", "3", "Elementary"};
    StudentInfo studentInfo = new StudentInfo();

    @Test
    public void testStudentAddition() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        int arraySize = studentInfo.getListSize();
        Assertions.assertTrue(arraySize == 3, "Arraylist is empty");
    }

    @Test
    public void testDisplayAllStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        Assertions.assertEquals(studentInfo.getStudentList(), 3,
                "Students info not displayed accurately");
    }

    @Test
    public void testEditStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        String id = "1";
        Student originalInfo = studentInfo.getStudentInfo(id);
        studentInfo.editStudent(id, infoNewBarrack);
        studentInfo.getStudentList();
        Student updatedInfo = studentInfo.getStudentInfo(id);
        Assertions.assertTrue(originalInfo.getAddress() != updatedInfo.getAddress(),
                "Information not update");
    }

    @Test
    public void testSearchStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        String id = "1";
        studentInfo.getStudentInfo(id);
        Assertions.assertTrue(studentInfo.getStudentInfo(id).getId() == infoBarrack[0],
                "Student id doesn't match");
    }

    @Test
    public void testDeleteStudent() {
        String id = "1";
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        studentInfo.deleteStudent(id);
        studentInfo.getStudentList();
        Assertions.assertNull(studentInfo.getStudentInfo(id), "Student not deleted");
    }
}
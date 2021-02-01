package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment18Test {
    String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
    String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
    String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
    String[] infoTrump = {"3", "Donald Trump", "Mar-a-lago", "3", "Elementary"};
    String[][] studentinfo = {infoBarrack, infoJoe, infoTrump};
    StudentInfo studentInfo = new StudentInfo();

    @Test
    public void testStudentAddition() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        Assertions.assertEquals(studentInfo.getListSize(), 3, "Arraylist is empty");
    }

    @Test
    public void testDisplayAllStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        String[][] getStudentinfo = studentInfo.getStudentList();
        for (int row = 0; row < getStudentinfo.length; row++) {
            for (int col = 0; col < getStudentinfo[0].length; col++) {
                Assertions.assertEquals(getStudentinfo[row][col], studentinfo[row][col],
                        "Student Data not printed completely");
            }
        }
    }

    @Test
    public void testEditStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        String id = "1";
        studentInfo.editStudent(id, infoNewBarrack);
        studentInfo.getStudentList();
        Student updatedInfo = studentInfo.getStudentInfo(id);
        Assertions.assertEquals(updatedInfo.getAddress(), infoNewBarrack[2],
                "Information not update");
    }

    @Test
    public void testSearchStudent() {
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        String id = "White House";
        studentInfo.getStudentInfo(id);
        Assertions.assertEquals(studentInfo.getStudentInfo(id).getId(), infoBarrack[0],
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
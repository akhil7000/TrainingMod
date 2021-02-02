package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Assignment18Test {
    String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
    String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
    String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
    String[] infoTrump = {"3", "Donald Trump", "Mar-a-lago", "3", "Elementary"};
    String[] infoBill = {"4", "Bill Clinton", "Whitehaven", "5", "PMMIWS"};
    String[][] studentArray = {infoBarrack, infoJoe, infoTrump};

    StudentInfo studentInfo = new StudentInfo();

    @Test
    public void testStudentAddition() {

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        Assertions.assertEquals(3, studentInfo.getListSize(), "Arraylist is empty");
    }

    @Test
    public void testDisplayAllStudent() {

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        studentInfo.getStudentList();

        Student student;
        ArrayList<Student> studentList = studentInfo.getStudentList();

        for (int row = 0; row < studentArray.length; row++) {
            student = studentList.get(row);
            Assertions.assertEquals(student.getId(), studentArray[row][0], "Id mismatch");
            Assertions.assertEquals(student.getName(), studentArray[row][1], "Name mismatch");
            Assertions.assertEquals(student.getAddress(), studentArray[row][2], "Address mismatch");
            Assertions.assertEquals(student.getStudentClass(), studentArray[row][3], "Class mismatch");
            Assertions.assertEquals(student.getSchool(), studentArray[row][4], "School mismatch");
        }
    }

    @Test
    public void testEditStudent() {

        String id = "1";

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        studentInfo.editStudent(id, infoNewBarrack);

        ArrayList<Student> updatedInfo = studentInfo.getStudentInfo(id);
        Assertions.assertEquals(updatedInfo.get(0).getAddress(), infoNewBarrack[2],
                "Information not updated");
    }

    @Test
    public void testSearchStudent() {

        String id = "New White House";

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        studentInfo.setStudentInfo(infoBill);

        /**
         * Test with pass condition
         */
        Assertions.assertEquals(studentInfo.getStudentInfo(id).get(0).getId(), infoJoe[0],
                "Student id doesn't match");

        /**
         * Test with failure condition
         */
        Assertions.assertTrue(studentInfo.getStudentInfo("6").isEmpty(), "Student id mismatch");
    }

    @Test
    public void testStudentSearchMultipleRecords() {

        String id = "PMMIWS";

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);
        studentInfo.setStudentInfo(infoBill);

        ArrayList<Student> studentRecord = studentInfo.getStudentInfo(id);
        Assertions.assertTrue(studentRecord.size() > 1, "Only one or no record exists");
    }

    @Test
    public void testDeleteStudent() {

        String id = "1";
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        studentInfo.deleteStudent(id);
        Assertions.assertTrue(studentInfo.getStudentInfo(id).isEmpty(), "Student not deleted");
    }
}
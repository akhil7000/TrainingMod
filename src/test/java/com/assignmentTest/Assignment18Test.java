package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment18Test {
    String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
    String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
    String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
    String[] infoTrump = {"3", "Donald Trump", "Mar-a-lago", "3", "Elementary"};
    String[][] student = {infoBarrack, infoJoe, infoTrump};

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

        Student[] studentArray = studentInfo.getStudentList();

        for (int row = 0; row < student.length; row++) {
            Assertions.assertEquals(studentArray[row].getId(), student[row][0], "Id mismatch");
            Assertions.assertEquals(studentArray[row].getName(), student[row][1], "Name mismatch");
            Assertions.assertEquals(studentArray[row].getAddress(), student[row][2], "Address mismatch");
            Assertions.assertEquals(studentArray[row].getStudentClass(), student[row][3], "Class mismatch");
            Assertions.assertEquals(studentArray[row].getSchool(), student[row][4], "School mismatch");
        }
    }

    @Test
    public void testEditStudent() {
        String id = "1";

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        studentInfo.editStudent(id, infoNewBarrack);
        studentInfo.getStudentList();
        Student updatedInfo = studentInfo.getStudentInfo(id);

        Assertions.assertEquals(updatedInfo.getAddress(), infoNewBarrack[2],
                "Information not updated");
    }

    @Test
    public void testSearchStudent() {
        String id = "New White House";

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.setStudentInfo(infoTrump);

        studentInfo.getStudentInfo(id);

        /**
         * Test with pass condition
         */
        Assertions.assertEquals(studentInfo.getStudentInfo(id).getId(), infoJoe[0],
                "Student id doesn't match");

        /**
         * Test with failure condition
         */
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
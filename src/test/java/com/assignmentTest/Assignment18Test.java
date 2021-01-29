package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Assignment18Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testStudent() {

        String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
        String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
        String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
        StudentInfo studentInfo = new StudentInfo();

        /**
         * Adding student info
         */
        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);

        /**
         * display all students information
         */
        studentInfo.getStudentList();

        /**
         * editting a student information
         */
        String originalInfo = studentInfo.getStudentInfo("1");
        studentInfo.editStudent("1", infoNewBarrack);
        String updatedInfo = studentInfo.getStudentInfo("1");
        Assertions.assertFalse(originalInfo != updatedInfo, "Information not updated");

        /**
         * searching for particular student based on id or name
         */
        studentInfo.getStudentInfo("1");

        /**
         * deleting student record
         */
        studentInfo.deleteStudent("1");
        studentInfo.getStudentList();
    }
}
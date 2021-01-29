package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Assignment18Test {

    @Test
    public void testStudent() {
        String[] infoBarrack = {"1", "Barrack Obama", "White House", "10", "PMMIWS"};
        String[] infoJoe = {"2", "Joe Biden", "New White House", "2", "MES"};
        String[] infoNewBarrack = {"1", "Barrack Obama", "Tudor House", "10", "PMMIWS"};
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setStudentInfo(infoBarrack);
        studentInfo.setStudentInfo(infoJoe);
        studentInfo.getStudentList();
        studentInfo.editStudent("1", infoNewBarrack);
        studentInfo.getStudentList();
        studentInfo.getStudentInfo("1");
        studentInfo.deleteStudent("1");
        studentInfo.getStudentList();
    }
}
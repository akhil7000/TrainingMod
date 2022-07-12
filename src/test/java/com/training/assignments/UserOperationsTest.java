package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserOperationsTest {
    UserOperations userOperations = new UserOperations();
    List<StudentInfo> listStudent = new ArrayList<StudentInfo>();


    @Test
    public void testInsertStudent() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));

        userOperations.insertStudent(listStudent);
        Assertions.assertNotNull(listStudent);
        Assertions.assertEquals(3, listStudent.size());
    }

    @Test
    public void testUpdateStudentById() {
        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));

        userOperations.updateStudentById(listStudent, 1, "priya", "Pune", "VIT");

        Assertions.assertEquals(listStudent.get(0).getAddress(), "Pune");
    }

    @Test
    public void testUpdateStudentByName() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));

        userOperations.updateStudentByName(listStudent, "riya", 3, "Delhi", "GIT");

    }

    @Test
    public void testDisplayStudent() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));
        userOperations.displayStudents(listStudent);

    }

    @Test
    public void testSearchStudentByName() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));
        Assertions.assertEquals(userOperations.searchStudentsByName(listStudent, "navi"), true);

    }

    @Test
    public void testSearchStudentById() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));

        Assertions.assertEquals(userOperations.searchStudentsById(listStudent, 2), true);

    }

    @Test
    public void testDeleteStudent() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1, "CJCS"));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3, "RAIT"));
        userOperations.delete(listStudent, 2);

        Assertions.assertEquals(listStudent.size(), 1);

    }

}
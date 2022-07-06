package com.training.assignments;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserOperationsTest {
    UserOperations userOperations = new UserOperations();
    StudentInfo studentInfo = new StudentInfo();

    List<StudentInfo> listStudent = new ArrayList<StudentInfo>();
    @Before
    public void initialize()
    {
        listStudent.add(new StudentInfo(1, "navi", "kk", 1));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3));
    }

    @Test
    public void testInsertStudent() {

        listStudent.add(new StudentInfo(1, "navi", "kk", 1));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3));

        userOperations.insertStudent(listStudent);
        Assertions.assertNotNull(listStudent);
        Assertions.assertEquals(3,listStudent.size());
    }

    @Test
    public void testUpdateStudent()
    {
        List<StudentInfo> listStudent = new ArrayList<StudentInfo>();
        listStudent.add(new StudentInfo(1, "navi", "kk", 1));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3));
        userOperations.updateStudent(listStudent,"navi");
        Assertions.assertEquals(listStudent.get(0).getAddress(),"Mumbai");

    }

    @Test
    public void testDeleteStudent()
    {
        List<StudentInfo> listStudent = new ArrayList<StudentInfo>();
        listStudent.add(new StudentInfo(1, "navi", "kk", 1));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3));
        userOperations.delete(listStudent,2);

        Assertions.assertEquals(listStudent.size(),1);

    }
    @Test
    public void testDisplayStudent()
    {
        List<StudentInfo> listStudent = new ArrayList<StudentInfo>();
        listStudent.add(new StudentInfo(1, "navi", "kk", 1));
        listStudent.add(new StudentInfo(2, "riya", "pp", 3));
        userOperations.displayStudents(listStudent);

    }
}
package com.training.assignments;

import java.util.List;
import java.util.Scanner;

public class UserOperations {

    StudentInfo studentInfo = new StudentInfo();

        public void delete(List<StudentInfo> listStudent, int id) {

        int index=0;
        try {
            for (StudentInfo std : listStudent)
            {
                if (std.getId() == id) {
                    break;
                }
                index++;

            }
            listStudent.remove(index);
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

    private void updateStudent(List<StudentInfo> listStudent, int id) {
        Scanner sc=new Scanner(System.in);
        for (StudentInfo std: listStudent) {

            if(std.getId()==id) {
                System.out.println("please enter the name to be updated");
                String name = sc.next();
                std.setName(name);

                System.out.println("please enter the address to be updated");
                String address = sc.next();
                std.setAddress(address);
            }
        }
    }
    public void updateStudent(List<StudentInfo> listStudent, String name) {
        for (StudentInfo std: listStudent) {

            if(std.getName().equals(name)) {

                String address="Mumbai";
                std.setAddress(address);
            }

        }
    }

    private void search(List<StudentInfo> listStudent, int id) {
        for (StudentInfo std : listStudent) {
            if (std.getId() == id) {
                System.out.println("ID: " + std.getId() + "\t Name: " + std.getName() + "\t Address: " + std.getAddress());
            }

        }
    }
        private void search(List<StudentInfo> listStudent, String name) {
            for(StudentInfo std: listStudent)
            {
                if(std.getName().equals(name))
                {
                    System.out.println("ID: "+std.getId()+ "\t Name: "+std.getName()+ "\t Address: "+ std.getAddress());
                }

            }
    }

    public void displayStudents(List<StudentInfo> listStudent) {

       if (listStudent.isEmpty()) {
            System.out.println("no students");
        } else {
            for (StudentInfo std : listStudent) {
                std.setSchoolName("CJCS");

                System.out.println("ID: "+std.getId()+ "\t Name: "+std.getName()+ "\t Address: "+ std.getAddress()+ "\t Class no :" +std.getClassNo()+
                        "\t SchoolName :"+std.getSchoolName());
            }
        }

    }

        public void insertStudent(List<StudentInfo> listStudent) {
            StudentInfo student = new StudentInfo();

            listStudent.add(new StudentInfo(3,"jack","ll",2));

            System.out.println("Student added successfully"+listStudent.toString());
        }
    }


package com.training.assignments.miniproject;

import java.util.List;

public class EmployeeOperation {

    public List<Employee1> getDeletedEmployee(int index, List<Employee1> employee) {
        employee.remove(index);
        return employee;
    }

//    public List<Employee1> getUpdatedEmployee(List<Employee1> employee1, int index) {
//        employee.add(index, employee1);
//        return employeeList;
//    }

    public String getUpdatedEmployee(int index, List<Employee1> employee, String name, String address, int salary, int id) {
        employee.add(index, employee1);
        return employeeList;
    }

//    public List<Employee> getCloneDeletedEmployee(int index) {
//        cloneEmployeeList.remove(index);
//        return cloneEmployeeList;
//    }
//
//    public List<Employee> getUpdatedEmployee(Employee employee1, int index) {
//        employeeList.add(index, employee1);
//        return employeeList;
//    }
//
//    public List<Employee> getCloneUpdatedEmployee(Employee employee2, int index) {
//        cloneEmployeeList.add(index, employee2);
//        return cloneEmployeeList;
//    }

}

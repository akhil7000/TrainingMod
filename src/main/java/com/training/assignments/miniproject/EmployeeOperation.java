package com.training.assignments.miniproject;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOperation {
    static List<com.training.assignments.miniproject.Employee> employeeList = new ArrayList<>();

    public void createEmployee(String name, String address, int salary, int id) {
        employeeList.add(new com.training.assignments.miniproject.Employee(name, address, salary, id));
    }

    public List<com.training.assignments.miniproject.Employee> getEmployee() {
        return employeeList;
    }

    public void deleteEmployee(int index) {
        employeeList.remove(index);
    }
}
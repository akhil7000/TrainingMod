package com.training.assignments.miniproject;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOperation {
    static List<EmployeeManagement> employeeList = new ArrayList<>();

    public void createEmployee(String name, String address, int salary, int id) {
        employeeList.add(new EmployeeManagement(name, address, salary, id));
    }

    public List<EmployeeManagement> getEmployee() {
        return employeeList;
    }

    public List<EmployeeManagement> getDeletedEmployee(int index, List<EmployeeManagement> employee) {
        employee.remove(index);
        return employee;
    }
}
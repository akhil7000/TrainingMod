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

    public void deleteEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                employeeToRemove = emp;
                break;
            }
        }
        employeeList.remove(employeeToRemove);
    }

    public void deleteEmployee(String name) {
        Employee employeeToRemove = null;
        for (Employee emp : employeeList) {
            if (emp.name.equalsIgnoreCase(name)) {
                employeeToRemove = emp;
                break;
            }
        }
        employeeList.remove(employeeToRemove);
    }

    public void updateEmployee(Employee employee) {
        employee.setName("Ashwini");
        employee.setAddress("Lokhandwala");
        employeeList.add(employee);
    }
}
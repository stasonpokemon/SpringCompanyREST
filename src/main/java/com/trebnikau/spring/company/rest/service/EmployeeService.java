package com.trebnikau.spring.company.rest.service;

import com.trebnikau.spring.company.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(int employeeId);
    void saveEmployee(Employee employee);
    void deleteEmployeeById(int employeeId);
}

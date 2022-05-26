package com.trebnikau.spring.company.rest.dao;

import com.trebnikau.spring.company.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(int employeeId);
    void saveEmployee(Employee employee);
    void deleteEmployeeById(int employeeId);
}

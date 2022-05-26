package com.trebnikau.spring.company.rest.service;

import com.trebnikau.spring.company.rest.dao.EmployeeDAO;
import com.trebnikau.spring.company.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeDAO.findAllEmployees();
        return employees;
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int employeeId) {
        Employee employee = employeeDAO.findEmployeeById(employeeId);
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);
    }
}

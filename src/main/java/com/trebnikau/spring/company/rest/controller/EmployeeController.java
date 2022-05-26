package com.trebnikau.spring.company.rest.controller;

import com.trebnikau.spring.company.rest.entity.Detail;
import com.trebnikau.spring.company.rest.entity.Employee;
import com.trebnikau.spring.company.rest.service.DetailService;
import com.trebnikau.spring.company.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DetailService detailService;

    @GetMapping("/employees")
    private List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    private Employee getEmployee(@PathVariable("id") int employeeId){
        return employeeService.findEmployeeById(employeeId);
    }

    @GetMapping("/employees/{id}/details")
    private Detail getDetailsFromEmployee(@PathVariable("id") int employeeId){
        Employee employeeById = employeeService.findEmployeeById(employeeId);
        if (employeeById != null) {
            Detail employeeByIdDetail = employeeById.getDetail();
            return employeeByIdDetail;
        } else {
            // some exception
            return null;
        }
    }

    @PostMapping("/employees")
    private Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PostMapping("/employees/{id}/details")
    private Employee addDetailsToEmployee(@RequestBody Detail detail, @PathVariable("id") int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee != null){
            detailService.saveDetail(detail);
            employee.setDetail(detail);
            employeeService.saveEmployee(employee);
        }
        return employee;
    }

    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees/details")
    private Detail updateEmployeeDetails(@RequestBody Detail detail){
        detailService.saveDetail(detail);
        return detail;
    }

    @DeleteMapping("/employees/{id}/details")
    private Employee deleteDetailsFromEmployee(@PathVariable("id") int employeeId){
        Employee employeeById = employeeService.findEmployeeById(employeeId);
        if(employeeById != null){
            Detail detailById = detailService.findDetailById(employeeById.getDetail().getId());
            if (detailById != null){
                employeeById.setDetail(null);
                employeeService.saveEmployee(employeeById);
                detailService.deleteDetailById(detailById.getId());
            }
        }
        return employeeById;
    }

    @DeleteMapping("/employees/{id}")
    private String deleteEmployee(@PathVariable("id") int employeeId){
        Employee employeeById = employeeService.findEmployeeById(employeeId);
        if (employeeById != null){
            employeeService.deleteEmployeeById(employeeId);
            return "Employee with id = " + employeeId + " was deleted";
        }
        else {
            return "There is no employee with id = " + employeeId + " into database";
        }
    }
}

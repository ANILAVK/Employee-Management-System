package com.retailcloud.employeemanagementsystem.controller;

import java.util.List;

import com.retailcloud.employeemanagementsystem.dto.EmployeeNameIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.employeemanagementsystem.dto.EmployeeDTO;
import com.retailcloud.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @PutMapping("/{id}/department")
    public EmployeeDTO updateEmployeeDepartment(@PathVariable Long id, @RequestParam Long departmentId) {
        return employeeService.updateEmployeeDepartment(id, departmentId);
    }

      @GetMapping
    public Page<EmployeeDTO> getAllEmployees(@RequestParam(defaultValue = "0") int page) {
        return employeeService.getAllEmployees(PageRequest.of(page, 20));
    }
    @GetMapping("/lookup")
    public List<EmployeeNameIdDTO> getEmployeeNamesAndIds(@RequestParam Boolean lookup) {
        return employeeService.getEmployeeNameAndIdList(lookup);
    } 
}

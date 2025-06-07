package com.retailcloud.employeemanagementsystem.service;

import java.util.List;

import com.retailcloud.employeemanagementsystem.dto.EmployeeNameIdDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.retailcloud.employeemanagementsystem.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO dto);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
    EmployeeDTO updateEmployeeDepartment(Long id, Long deptId);
    Page<EmployeeDTO> getAllEmployees(Pageable pageable);
List<EmployeeNameIdDTO> getEmployeeNameAndIdList(Boolean lookup);}

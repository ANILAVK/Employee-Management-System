package com.retailcloud.employeemanagementsystem.mapper;

import com.retailcloud.employeemanagementsystem.dto.EmployeeDTO;
import com.retailcloud.employeemanagementsystem.entity.Department;
import com.retailcloud.employeemanagementsystem.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setDateOfBirth(e.getDateOfBirth());
        dto.setSalary(e.getSalary());
        dto.setAddress(e.getAddress());
        dto.setRole(e.getRole());
        dto.setJoiningDate(e.getJoiningDate());
        dto.setYearlyBonusPercentage(e.getYearlyBonusPercentage());
        if (e.getDepartment() != null) {
            dto.setDepartmentId(e.getDepartment().getId());
            dto.setDepartmentName(e.getDepartment().getName());
        }
        if (e.getReportingManager() != null) {
            dto.setReportingManagerId(e.getReportingManager().getId());
            dto.setReportingManagerName(e.getReportingManager().getName());
        }
        return dto;
    }
    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setSalary(dto.getSalary());
        employee.setAddress(dto.getAddress());
        employee.setRole(dto.getRole());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setYearlyBonusPercentage(dto.getYearlyBonusPercentage());

        if (dto.getDepartmentId() != null) {
            Department department = new Department();
            department.setId(dto.getDepartmentId());
            department.setName(dto.getDepartmentName()); // Optional: Usually only ID is needed to set relationship
            employee.setDepartment(department);
        }

        if (dto.getReportingManagerId() != null) {
            Employee manager = new Employee();
            manager.setId(dto.getReportingManagerId());
            manager.setName(dto.getReportingManagerName()); // Optional: Usually only ID is needed
            employee.setReportingManager(manager);
        }

        return employee;
    }

}

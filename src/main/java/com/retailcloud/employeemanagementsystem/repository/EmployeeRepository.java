package com.retailcloud.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailcloud.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrderByNameAsc();
    List<Employee> findByDepartmentId(Long id);


}

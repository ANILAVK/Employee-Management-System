package com.retailcloud.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailcloud.employeemanagementsystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    
}

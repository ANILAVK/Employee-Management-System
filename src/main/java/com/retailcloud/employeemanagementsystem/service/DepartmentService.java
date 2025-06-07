package com.retailcloud.employeemanagementsystem.service;

import com.retailcloud.employeemanagementsystem.dto.DepartmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO dto);
    String deleteDepartment(Long id);
    DepartmentDTO updateDepartment(Long id, DepartmentDTO dto);
    Page<DepartmentDTO> getAllDepartments(Pageable pageable);
    DepartmentDTO getDepartmentWithEmployees(Long id,String expand);
}

package com.retailcloud.employeemanagementsystem.mapper;

import com.retailcloud.employeemanagementsystem.dto.DepartmentDTO;
import com.retailcloud.employeemanagementsystem.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO toDTO(Department d) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(d.getId());
        dto.setName(d.getName());
        dto.setCreationDate(d.getCreationDate());
        if (d.getDepartmentHead() != null) {
            dto.setDepartmentHeadId(d.getDepartmentHead().getId());
            dto.setDepartmentHeadName(d.getDepartmentHead().getName());
        }
        return dto;
    }
}

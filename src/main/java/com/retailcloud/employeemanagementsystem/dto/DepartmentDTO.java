package com.retailcloud.employeemanagementsystem.dto;

import java.time.LocalDate;
import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String name;
    private LocalDate creationDate;
    private List<EmployeeDTO> employeeDTOS;

    private Long departmentHeadId;
    private String departmentHeadName;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public Long getDepartmentHeadId() {
        return departmentHeadId;
    }
    public void setDepartmentHeadId(Long departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }
    public String getDepartmentHeadName() {
        return departmentHeadName;
    }
    public void setDepartmentHeadName(String departmentHeadName) {
        this.departmentHeadName = departmentHeadName;
    }

    public List<EmployeeDTO> getEmployeeDTOS() {
        return employeeDTOS;
    }

    public void setEmployeeDTOS(List<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", employeeDTOS=" + employeeDTOS +
                ", departmentHeadId=" + departmentHeadId +
                ", departmentHeadName='" + departmentHeadName + '\'' +
                '}';
    }


}

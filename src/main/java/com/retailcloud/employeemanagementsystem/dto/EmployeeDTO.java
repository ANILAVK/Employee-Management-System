package com.retailcloud.employeemanagementsystem.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Double salary;
    private String address;
    private String role;
    private LocalDate joiningDate;
    private Double yearlyBonusPercentage;

    private Long departmentId;
    private String departmentName;

    private Long reportingManagerId;
    private String reportingManagerName;
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
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    public Double getYearlyBonusPercentage() {
        return yearlyBonusPercentage;
    }
    public void setYearlyBonusPercentage(Double yearlyBonusPercentage) {
        this.yearlyBonusPercentage = yearlyBonusPercentage;
    }
    public Long getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Long getReportingManagerId() {
        return reportingManagerId;
    }
    public void setReportingManagerId(Long reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }
    public String getReportingManagerName() {
        return reportingManagerName;
    }
    public void setReportingManagerName(String reportingManagerName) {
        this.reportingManagerName = reportingManagerName;
    }
    @Override
    public String toString() {
        return "EmployeeDTO [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary
                + ", address=" + address + ", role=" + role + ", joiningDate=" + joiningDate
                + ", yearlyBonusPercentage=" + yearlyBonusPercentage + ", departmentId=" + departmentId
                + ", departmentName=" + departmentName + ", reportingManagerId=" + reportingManagerId
                + ", reportingManagerName=" + reportingManagerName + "]";
    }

   
}

package com.retailcloud.employeemanagementsystem.exception;

 public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee not found with ID: " + id);
    }

}
    


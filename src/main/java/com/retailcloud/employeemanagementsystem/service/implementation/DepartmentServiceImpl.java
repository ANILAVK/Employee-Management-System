package com.retailcloud.employeemanagementsystem.service.implementation;


import com.retailcloud.employeemanagementsystem.dto.DepartmentDTO;
import com.retailcloud.employeemanagementsystem.dto.EmployeeDTO;
import com.retailcloud.employeemanagementsystem.entity.Department;
import com.retailcloud.employeemanagementsystem.entity.Employee;
import com.retailcloud.employeemanagementsystem.exception.DepartmentDeleteException;
import com.retailcloud.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.retailcloud.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.retailcloud.employeemanagementsystem.exception.InvalidExpandParameterException;
import com.retailcloud.employeemanagementsystem.mapper.DepartmentMapper;
import com.retailcloud.employeemanagementsystem.repository.DepartmentRepository;
import com.retailcloud.employeemanagementsystem.repository.EmployeeRepository;
import com.retailcloud.employeemanagementsystem.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.retailcloud.employeemanagementsystem.mapper.DepartmentMapper.toDTO;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentDTO addDepartment(DepartmentDTO dto) {
        Department dept = new Department();
        dept.setName(dto.getName());
        dept.setCreationDate(dto.getCreationDate());
        if (dto.getDepartmentHeadId() != null) {
            dept.setDepartmentHead(employeeRepository.findById(dto.getDepartmentHeadId()).orElse(null));
        }
        return toDTO(departmentRepository.save(dept));
    }
@Override
public String deleteDepartment(Long id) {
    Department department = departmentRepository.findById(id)
        .orElseThrow(() -> new DepartmentNotFoundException(id));

    List<Employee> assigned = employeeRepository.findByDepartmentId(id);
    if (!assigned.isEmpty()) {
        throw new DepartmentDeleteException("Cannot delete department. Employees are assigned.");
    }

    departmentRepository.deleteById(id);
    return "Department deleted successfully.";
}

    @Override
public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
    Department dept = departmentRepository.findById(id)
        .orElseThrow(() -> new DepartmentNotFoundException(id));

    dept.setName(dto.getName());
    dept.setCreationDate(dto.getCreationDate());

    if (dto.getDepartmentHeadId() != null) {
        Employee head = employeeRepository.findById(dto.getDepartmentHeadId())
            .orElseThrow(() -> new EmployeeNotFoundException(dto.getDepartmentHeadId()));
        dept.setDepartmentHead(head);
    }

    return toDTO(departmentRepository.save(dept));
}


    @Override
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable).map(DepartmentMapper::toDTO);
    }

    @Override
public DepartmentDTO getDepartmentWithEmployees(Long id, String expand) {
    if (!"employee".equalsIgnoreCase(expand)) {
        throw new InvalidExpandParameterException("Invalid value for expand parameter. Expected 'employee'.");
    }

    Department dept = departmentRepository.findById(id)
        .orElseThrow(() -> new DepartmentNotFoundException(id));

    DepartmentDTO dto = toDTO(dept);

    List<EmployeeDTO> empList = employeeRepository.findByDepartmentId(id)
        .stream()
        .map(e -> {
            EmployeeDTO edto = new EmployeeDTO();
            edto.setId(e.getId());
            edto.setName(e.getName());
            return edto;
        }).toList();

    dto.setEmployeeDTOS(empList);
    return dto;
}


       
}

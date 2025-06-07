package com.retailcloud.employeemanagementsystem.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.retailcloud.employeemanagementsystem.dto.EmployeeNameIdDTO;
import com.retailcloud.employeemanagementsystem.mapper.EmployeeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retailcloud.employeemanagementsystem.dto.EmployeeDTO;
import com.retailcloud.employeemanagementsystem.entity.Department;
import com.retailcloud.employeemanagementsystem.entity.Employee;
import com.retailcloud.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.retailcloud.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.retailcloud.employeemanagementsystem.exception.InvalidLookupParameterException;
import com.retailcloud.employeemanagementsystem.repository.DepartmentRepository;
import com.retailcloud.employeemanagementsystem.repository.EmployeeRepository;
import com.retailcloud.employeemanagementsystem.service.EmployeeService;

import static com.retailcloud.employeemanagementsystem.mapper.EmployeeMapper.toDTO;
import static com.retailcloud.employeemanagementsystem.mapper.EmployeeMapper.toEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{


    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {

       Employee employee = toEntity(dto);

       employee = employeeRepository.save(employee);

       return toDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
       Employee emp = employeeRepository.findById(id)
    .orElseThrow(() -> new EmployeeNotFoundException(id));

        if (dto.getName() != null) {
            emp.setName(dto.getName());
        }
        if (dto.getDateOfBirth() != null) {
            emp.setDateOfBirth(dto.getDateOfBirth());
        }
        if (dto.getSalary() != null) {
            emp.setSalary(dto.getSalary());
        }
        if (dto.getAddress() != null) {
            emp.setAddress(dto.getAddress());
        }
        if (dto.getRole() != null) {
            emp.setRole(dto.getRole());
        }
        if (dto.getJoiningDate() != null) {
            emp.setJoiningDate(dto.getJoiningDate());
        }
        if (dto.getYearlyBonusPercentage() != null) {
            emp.setYearlyBonusPercentage(dto.getYearlyBonusPercentage());
        }
        return toDTO(employeeRepository.save(emp));
    }

    @Override
    public EmployeeDTO updateEmployeeDepartment(Long id, Long deptId) {
Employee emp = employeeRepository.findById(id)
    .orElseThrow(() -> new EmployeeNotFoundException(id));       
     Department dept = departmentRepository.findById(deptId)
    .orElseThrow(() -> new DepartmentNotFoundException(deptId));
        emp.setDepartment(dept);
        return toDTO(employeeRepository.save(emp));
    }

    @Override
    public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(EmployeeMapper::toDTO);

    }

   @Override
    public List<EmployeeNameIdDTO> getEmployeeNameAndIdList(Boolean lookup) {
if (lookup == null || !lookup) {
    throw new InvalidLookupParameterException("The 'lookup' parameter must be true to retrieve data.");
}        return employeeRepository.findAllByOrderByNameAsc()
                .stream()
                .map(e -> {
                    EmployeeNameIdDTO dto = new EmployeeNameIdDTO();
                    dto.setId(e.getId());
                    dto.setName(e.getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }
    
}

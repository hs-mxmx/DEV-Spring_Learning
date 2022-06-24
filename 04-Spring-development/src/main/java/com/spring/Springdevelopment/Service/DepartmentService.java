package com.spring.Springdevelopment.Service;

import com.spring.Springdevelopment.Entity.Department;
import com.spring.Springdevelopment.ErrorHandler.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;
    String deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, Department department);
    Department fetchDepartmentByName(String departmentName);
}

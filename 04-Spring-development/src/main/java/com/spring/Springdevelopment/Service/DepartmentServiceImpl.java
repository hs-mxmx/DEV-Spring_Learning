package com.spring.Springdevelopment.Service;

import com.spring.Springdevelopment.Entity.Department;
import com.spring.Springdevelopment.ErrorHandler.DepartmentNotFoundException;
import com.spring.Springdevelopment.Logger.LoggerDepartment;
import com.spring.Springdevelopment.Repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    public LoggerDepartment loggerDepartment = new LoggerDepartment("debug","");
    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Found!");
        }
        loggerDepartment.DepartmentServiceGenericLog("fetchDepartmentById");
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long id) {
        try{
            Department department = departmentRepository.findById(id).get();
            departmentRepository.deleteById(id);
            loggerDepartment.DepartmentServiceGenericLog("deleteDepartmentById");
            return "Department removed: " + department;
            }catch(Exception ex){
                return "Something went wrong, try again...";
            }
    }
    @Override
    public String updateDepartmentById(Long id, Department department) {
        try {
            Department newDepartment = departmentRepository.findById(id).get();
            Department oldDepartment = new Department();
            BeanUtils.copyProperties(newDepartment, oldDepartment);

            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                newDepartment.setDepartmentName(department.getDepartmentName());
            }

            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                newDepartment.setDepartmentCode(department.getDepartmentCode());
            }

            if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                newDepartment.setDepartmentAddress(department.getDepartmentAddress());
            }

            departmentRepository.save(newDepartment);
            loggerDepartment.DepartmentServiceGenericLog("updateDepartmentById");
            return "[!] New update has been done: \nDepartment: " + oldDepartment + "\nNew Department: " + newDepartment;

        } catch (Exception ex) {
            return "Something went wrong... " + ex;
        }
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        loggerDepartment.DepartmentServiceGenericLog("fetchDepartmentByName");
        return departmentRepository.findBydepartmentNameIgnoreCase(departmentName);
    }
}

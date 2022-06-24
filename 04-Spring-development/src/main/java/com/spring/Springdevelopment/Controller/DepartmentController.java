package com.spring.Springdevelopment.Controller;

import com.spring.Springdevelopment.Entity.Department;
import com.spring.Springdevelopment.ErrorHandler.DepartmentNotFoundException;
import com.spring.Springdevelopment.Logger.LoggerDepartment;
import com.spring.Springdevelopment.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
   @Autowired
   LoggerDepartment departmentControllerGenericLog = new LoggerDepartment("info","");

    @PutMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        departmentControllerGenericLog.DepartmentControllerGenericLog("saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        departmentControllerGenericLog.DepartmentControllerGenericLog("fetchDepartmentList");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentControllerGenericLog.DepartmentControllerGenericLog("fetchDepartmentById");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentControllerGenericLog.DepartmentControllerGenericLog("deleteDepartmentById");
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/departments/{id}")
    public String updateDepartment(@PathVariable("id") Long departmentId,
                                   @RequestBody Department department){
        departmentControllerGenericLog.DepartmentControllerGenericLog("updateDepartment");
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        departmentControllerGenericLog.DepartmentControllerGenericLog("fetchDepartmentByName");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}

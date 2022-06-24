package com.spring.Springdevelopment.Service;

import com.spring.Springdevelopment.Entity.Department;
import com.spring.Springdevelopment.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("DEV")
                        .departmentAddress("Spain")
                        .departmentCode("Dev-01")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("DEV")).thenReturn(department);
    }

    @Test
    void saveDepartment() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartmentById() {
    }

    @Test
    @DisplayName("whenFindByIgnoreCaseName_thenReturnDepartment - Get Data based on Department Name")
    void whenFindByIgnoreCaseName_thenReturnDepartment() {
        String departmentName = "DEV";
        Department departmentFound = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, departmentFound.getDepartmentName());
    }
}
package com.spring.Springdevelopment.Repository;

import com.spring.Springdevelopment.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("MECH")
                .departmentCode("MECH - 01")
                .departmentAddress("Spain")
                .build();

        entityManager.persist(department);
        entityManager.flush();
    }

    @Test
    @DisplayName("whenFindByNameIgnorecase - Get departmentName ignoring case by giving ID")
    public void whenFindByNameIgnorecase(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "MECH");
    }
}
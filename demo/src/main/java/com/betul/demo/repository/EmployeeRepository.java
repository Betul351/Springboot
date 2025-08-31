package com.betul.demo.repository;

import com.betul.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String name);
    List<Employee> findByDepartment_Name(String departmentName);

    @Query("SELECT e.id FROM Employee e WHERE e.salary > :amount")
    List<Employee> findBySalaryGreaterThan(@Param("amount") Integer amount);

    @Query(value = "SELECT e FROM Employee e WHERE e.department.name= :dept")
    List<Employee> findByDepartmentNative(@Param("dept") String dept);

}

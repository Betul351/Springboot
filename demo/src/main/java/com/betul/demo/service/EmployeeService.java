package com.betul.demo.service;

import com.betul.demo.entity.Employee;
import com.betul.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee update(Long id,Employee updateEmployee){
        Employee existing = findById(id);
        existing.setName(updateEmployee.getName());
        existing.setEmail(updateEmployee.getEmail());
        existing.setSalary(updateEmployee.getSalary());
        existing.setDepartment(updateEmployee.getDepartment());
        return employeeRepository.save(existing);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchByName(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> searchByDepartment(String departmentName){
        return employeeRepository.findByDepartment_Name(departmentName);
    }

    public List<Employee> findBySalaryGreaterThan(Integer amount){
        return employeeRepository.findBySalaryGreaterThan(amount);
    }

    public List<Employee> findByDepartmentNative(String dept){
        return employeeRepository.findByDepartmentNative(dept);
    }

    public Page<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }



}

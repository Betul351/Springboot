package com.betul.demo.service;

import com.betul.demo.entity.Employee;
import com.betul.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
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
        return employeeRepository.save(existing);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }


}

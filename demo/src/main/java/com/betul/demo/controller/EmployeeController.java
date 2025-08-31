package com.betul.demo.controller;

import com.betul.demo.entity.Employee;
import com.betul.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String name){
        return employeeService.searchByName(name);
    }

    @GetMapping("/by-department")
    public List<Employee> searchByDepartment(@RequestParam String department){
        return employeeService.searchByDepartment(department);
    }

    @GetMapping("/search/by-salary")
    public List<Employee> searchBySalary(@RequestParam Integer amount){
        return employeeService.findBySalaryGreaterThan(amount);
    }

    @GetMapping("/search/native-department")
    public List<Employee> searchNative(@RequestParam String dept){
        return employeeService.findByDepartmentNative(dept);
    }

    @GetMapping("/paged")
    public Page<Employee> getEmployees(Pageable pageable){
        return employeeService.getAllEmployees(pageable);
    }



}

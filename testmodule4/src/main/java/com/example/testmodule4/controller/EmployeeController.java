package com.example.testmodule4.controller;

import com.example.testmodule4.model.Employee;
import com.example.testmodule4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> findALl(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id){
        Employee plan= employeeService.findById(id);
        return new ResponseEntity<>(plan,HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Employee employee){
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody Employee employee){
        Employee employee1=employeeService.findById(id);
        if (employee1!=null){
            employeeService.update(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/categories/salary/get/{id}")
//    public ResponseEntity<Double> getMoneyById(@PathVariable Long id){
//        return new ResponseEntity<>(employeeService.getMoneyById(id),HttpStatus.OK);
//    }
}

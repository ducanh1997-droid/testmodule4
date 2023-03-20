package com.example.testmodule4.service.impl;

import com.example.testmodule4.model.Employee;
import com.example.testmodule4.repository.IEmployeeRepository;
import com.example.testmodule4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllDepartment() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {

        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepository.deleteById(id);
    }

//    @Override
//    public List<Employee> findByPrice(Double price, Double price1) {
//        return null;
//    }



    @Override
    public List<Employee> findByName(String name,String category) {
        return iEmployeeRepository.findByName("%" + name + "%","%" + category + "%");
    }

    @Override
    public List<Employee> findByNameCategory(String department) {
        return iEmployeeRepository.findByNameCategory(department);
    }
}

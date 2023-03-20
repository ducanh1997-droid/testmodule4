package com.example.testmodule4.service.impl;

import com.example.testmodule4.model.Department;
import com.example.testmodule4.model.Employee;
import com.example.testmodule4.repository.IDepartmentRepository;
import com.example.testmodule4.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository iDepartmentRepository;


    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }

    @Override
    public List<Department> findAllSort() {
        return null;
    }

    @Override
    public List<Department> findByName(String name, String department) {
        return null;
    }

    @Override
    public List<Department> findByNameCategory(String department) {
        return null;
    }

    @Override
    public List<Department> findAllDepartment() {
        return (List<Department>) iDepartmentRepository.findAll();
    }
    @Override
    public Department findById(Long id) {
        return iDepartmentRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Department department) {
        iDepartmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        iDepartmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        iDepartmentRepository.deleteEmployee(id);
        iDepartmentRepository.deleteById(id);
    }


}

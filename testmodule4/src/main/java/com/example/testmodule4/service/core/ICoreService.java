package com.example.testmodule4.service.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICoreService<E> {
    List<E> findAll();
    List<E> findByName(String name,String department);

    List<E> findByNameCategory(String department);
    List<E> findAllDepartment();
    E findById(Long id);

    void create(E e);

    void update(E e);

    void delete(Long id);
}

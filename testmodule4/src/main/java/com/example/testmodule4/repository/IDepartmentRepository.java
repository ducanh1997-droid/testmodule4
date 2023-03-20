package com.example.testmodule4.repository;

import com.example.testmodule4.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDepartmentRepository extends JpaRepository<Department,Long> {
    @Modifying
    @Query(value = "delete from Department c where c.id = :id")
    void deleteById(@Param("id") Long id);
    @Modifying
    @Query(value = "delete from Employee p where p.department.id = :idDepartment")
    void deleteEmployee(@Param("idDepartment") Long id);
}


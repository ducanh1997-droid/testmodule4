package com.example.testmodule4.repository;

import com.example.testmodule4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select p from Employee p inner join Department c on p.department.id = c.id where c.name like :department and p.name like :name")
        //annotation @Query sử dụng để build customize query trong JPA
        //annotation @Param dùng để thêm tham số vào câu native query theo tên tương ứng
    List<Employee> findByName(@Param("name") String name, @Param("department") String department);


    @Query(value = "select p from Employee p inner join Department c on p.department.id = c.id where c.name = :department")
        //annotation @Query sử dụng để build customize query trong JPA
        //annotation @Param dùng để thêm tham số vào câu native query theo tên tương ứng
    List<Employee> findByNameCategory(@Param("department") String department);
}

package com.smart.ware.domain.department.repository;

import com.smart.ware.domain.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentCode(String code);

    Optional<Department> findByDepartmentName(String name);

}

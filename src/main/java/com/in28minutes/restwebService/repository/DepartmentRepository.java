package com.in28minutes.restwebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.restwebService.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}

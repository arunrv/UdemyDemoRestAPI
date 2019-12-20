package com.in28minutes.restwebService.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.in28minutes.restwebService.Entity.Department;

public interface DeptService {
 
	void saveDeparmetn(Department dept);
	List<Department> getAllDepartment();
	Department findbyDid(String id);
	void deptEdit(Department dept);
	List<Department> getAlldeptPagination(int pagenum, int count);
}

package com.in28minutes.restwebService.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.in28minutes.restwebService.Entity.Department;
import com.in28minutes.restwebService.Entity.PaginationModel;
import com.in28minutes.restwebService.service.DeptService;

import io.swagger.models.HttpMethod;

@RestController
@RequestMapping(value="/DeparmentController")
public class DepartmentController {
	
	@Autowired
	DeptService deptservice;
	
	
	@PostMapping("/dept")
	public ResponseEntity<Object> createDepartment(@RequestBody Department dept)
	{
		
		deptservice.saveDeparmetn(dept);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dept.getDid()).toUri();
		
		ResponseEntity<Object> respEntity = ResponseEntity.created(uri).build();
		
		return respEntity;
		
	}
	
	@GetMapping("/dept/getAll")
	public List<Department> getAllDepartments()
	{
		List<Department> depList = deptservice.getAllDepartment();
		return depList;
	}
	
	@GetMapping("/dept/{id}")
	public Department findBydeptId(@PathVariable String id)
	{
		Department dept = deptservice.findbyDid(id);
		return dept;
	}
	
	@GetMapping("/dept")
	public Department findbydid(@RequestParam String id)
	{
		Department dept = deptservice.findbyDid(id);
		return dept;
	}
	
	@PutMapping("/dept123")
	public ResponseEntity<Object> editDept(@RequestBody Department dept)
	{
		
		deptservice.deptEdit(dept);
URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dept.getDid()).toUri();
		
		ResponseEntity<Object> respEntity = ResponseEntity.created(uri).build();
		
		return respEntity;
		
	}
	@PostMapping("/getPagenatedDept")
	public List<Department> getAllpagenatedDept(@RequestBody PaginationModel pmodel)
	{
		List<Department> list2 = deptservice.getAlldeptPagination(pmodel.getPageNum(), pmodel.getSize());
		return list2;
		
	}
	

}

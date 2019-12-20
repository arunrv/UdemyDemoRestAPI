package com.in28minutes.restwebService.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.in28minutes.restwebService.Entity.Department;
import com.in28minutes.restwebService.repository.DepartmentRepository;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DepartmentRepository deptrepo;
	
	@Override
	public void saveDeparmetn(Department dept) {
		Optional<Department> dept1 = deptrepo.findById(dept.getDid());
		if(!dept1.isPresent())
		deptrepo.save(dept);
		else
			throw new RuntimeException("Only Post is allowed, for edit use put call");
		
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> deptList = deptrepo.findAll();
		return deptList;
	}

	@Override
	public Department findbyDid(String id) {
		Optional<Department> dept = deptrepo.findById(id);
		if(dept.isPresent())
		return dept.get();
		else
			throw new RuntimeException();
	}

	@Override
	public void deptEdit(Department dept) {
		Optional<Department> dept1 = deptrepo.findById(dept.getDid());
		if(dept1.isPresent())
		{
			Department dept2 = dept1.get();
			dept2.setDname(dept.getDname());
			dept2.setLocation(dept.getLocation());
			dept2.setRating(dept.getRating());
			deptrepo.save(dept2);
		}
		else
			throw new RuntimeException("****Post Call is not allowed*******");
		
	}

	@Override
	public List<Department> getAlldeptPagination(int pagenum, int count) {
		
		List<Department> list2=new ArrayList<>();
		//PageRequest pagable = null;
		Page<Department> pagableDeptList=null;
		do {
			PageRequest pagable = PageRequest.of(pagenum, count);
			pagableDeptList = deptrepo.findAll(pagable);
			List<Department> list1 = pagableDeptList.getContent();
			list1.stream().forEach(dept->list2.add(dept));
			pagenum++;
			System.out.println(list2);
			
		}
		while(!pagableDeptList.isLast());
		//while(pagableDeptList.getNumberOfElements())
		System.out.println(list2.size());
		
		return list2;
	}
	
	public void uploadDatatoCSV() throws FileNotFoundException, IOException
	{
		int pageNum=0;
		int size=4;
		String fileName="C:\\Users\\ARUNR11\\Desktop\\High priority ticket\\Jar 2\\abc2.csv";
		PageRequest pagable=null;
		try
		{
			FileOutputStream fos=new FileOutputStream(fileName); 
			fos.write(239);
			fos.write(187);
			fos.write(191);
			OutputStreamWriter oos=new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			Writer writer=new BufferedWriter(oos);
			
			
			String header="id"+","+"dept_name"+","+"location"+","+"rating";
			writer.write(header);
			writer.write("\n");
			
			Page<Department> deptPage=null;
			do
			{
				//String id;
				//String dept_name;
				//String location;
				//int rating;
				pagable=PageRequest.of(pageNum, size);
				deptPage=deptrepo.findAll(pagable);
				deptPage.getContent().stream().forEach(dept->{
				String id=dept.getDid();
				String dept_name=dept.getDname();
				String location=dept.getLocation();
				int rating=dept.getRating();
				String row=id+","+dept_name+","+location+","+rating;
				try {
					writer.write(row);
					writer.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				});
				pageNum++;
				
				
			}
			while(!deptPage.isLast());
			writer.close();
			
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	

	
}

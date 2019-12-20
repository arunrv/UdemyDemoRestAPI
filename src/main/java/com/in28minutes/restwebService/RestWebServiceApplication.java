package com.in28minutes.restwebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.restwebService.Controller.PostController;
import com.in28minutes.restwebService.service.DeptServiceImpl;


@SpringBootApplication
public class RestWebServiceApplication implements CommandLineRunner  {
	
	@Autowired
	private PostController postcontroller;
	
	@Autowired
	DeptServiceImpl deptimpl;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(RestWebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//postcontroller.getAllPostsWithUsers();
		deptimpl.uploadDatatoCSV();
		
	}

}

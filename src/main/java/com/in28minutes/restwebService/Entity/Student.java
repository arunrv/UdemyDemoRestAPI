package com.in28minutes.restwebService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String sid;
	
	@Column(name="StuentName")
	String name;
	
	@Column(name="rollNo")
	String rollno;
	
	@Column(name="FatherName")
	String fatherName;
	
	@Column(name="MotherName")
	String motherName;
	
	@Column(name="percentage")
	double percentage;
	
	@Column(name="mentor")
	String mentor;
	
	@ManyToOne
	Department deptId;
	
}

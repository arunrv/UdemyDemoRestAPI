package com.in28minutes.restwebService.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name="DeptId")
	String Did;
	
	@Column(name="DeptName")
	String Dname;
	
	@Column(name="Location")
	String location;
	
	@Column(name="Rating")
	Integer rating;
	
	@OneToMany(mappedBy="deptId")
	@JsonIgnore
	List<Student> studentList;

	public String getDid() {
		return Did;
	}

	public void setDid(String did) {
		Did = did;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Department [Did=" + Did + ", Dname=" + Dname + ", location=" + location + ", rating=" + rating
				+ ", studentList=" + studentList + "]";
	}
	
	
	

}

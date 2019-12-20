package com.in28minutes.restwebService.Entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
//@NoArgsConstructor @AllArgsConstructor
public class UsersJPA
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Minimum 2 characters")
	@Column(name="UserName", nullable=false)
	private String name;
	
	@Column(name="DateOfBirth", nullable=false)
	//@Past
	//@JsonIgnore
	@ApiModelProperty(notes="Date of birth should be past not future")
	private Date dob;
	
	@CreatedDate
	private Date creationdate;
	
	@LastModifiedDate
	private Date updatedate;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post)
	{
		posts.add(post);
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	

	protected UsersJPA() {
		super();
	}

	public UsersJPA(Integer id, String name, Date dob, Date creationdate, Date updatedate) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.creationdate=creationdate;
		this.updatedate=updatedate;
	}

	/*@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	

}

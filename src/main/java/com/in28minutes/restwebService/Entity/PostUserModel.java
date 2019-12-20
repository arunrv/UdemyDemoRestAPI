package com.in28minutes.restwebService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class PostUserModel 
{
	private Post post;
	private UsersJPA user;
	/*private Integer Userid;
	private String Username;
	private Date Userdob;*/
	
	
	public PostUserModel() {
		super();
	}
	/*@Override
	public String toString() {
		return "PostUserModel [post=" + post + ", users=" + users + "]";
	}*/
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	/*public Integer getUserid() {
		return Userid;
	}
	public void setUserid(Integer userid) {
		Userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Date getUserdob() {
		return Userdob;
	}
	public void setUserdob(Date userdob) {
		Userdob = userdob;
	}*/
	public UsersJPA getUser() {
		return user;
	}
	public void setUser(UsersJPA user) {
		this.user = user;
	}
	
	
	
	

}

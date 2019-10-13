package com.fristProject.articleRecomender.post;

import java.util.Date;

import com.fristProject.articleRecomender.user.User;

public class Post {

	private Integer id;
	private String name;
	//Weak
	private User user;
	
	protected Post() {
		
	}
	public Post(Integer id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}
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
//	public Date getBirthDate() {
//		return birthDate;
//	}
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}
	
}

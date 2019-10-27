package com.fristProject.articleRecomender.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fristProject.articleRecomender.user.User;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer post_id;
	private String name;
	//Weak
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	protected Post() {
		
	}
	public Post(Integer post_id, String name, User user) {
		super();
		this.post_id = post_id;
		this.name = name;
		this.user = user;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

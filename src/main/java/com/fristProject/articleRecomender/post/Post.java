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
	private String title;
	//Weak
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	protected Post() {
		
	}
	public Post(Integer post_id, String title, User user) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.user = user;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

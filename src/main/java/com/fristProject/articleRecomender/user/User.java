package com.fristProject.articleRecomender.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"orgnization"})
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	//validation min car
	
	@Size(min=2)
	private String name;
	//validation past
	@Past
	private Date birthDate;
//	@JsonIgnore
//	private String orgnization = "dbs";

	protected User() {
		
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
//	public String getOrgnization() {
//		return orgnization;
//	}
//	public void setOrgnization(String orgnization) {
//		this.orgnization = orgnization;
//	}
	
}

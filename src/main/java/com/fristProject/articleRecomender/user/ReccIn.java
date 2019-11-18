package com.fristProject.articleRecomender.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "recc_out3")
public class ReccIn {
	
	@Id
	private Integer userId;
	
    @Size(max = 100)
    private String name;
	
	@NotNull
    @Size(max = 100)
    private String reccValues;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReccValues() {
		return reccValues;
	}

	public void setReccValues(String reccValues) {
		this.reccValues = reccValues;
	}

	public ReccIn(Integer userId, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 100) String reccValues) {
		super();
		this.userId = userId;
		this.name = name;
		this.reccValues = reccValues;
	}

	protected ReccIn() {
		
	}
}

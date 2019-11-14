package com.fristProject.articleRecomender.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recc_out3")
public class ReccIn {
	
	@Id
	private Integer userId;
	
	@NotNull
    @Size(max = 100)
    private String reccValues;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getReccValues() {
		return reccValues;
	}

	public void setReccValues(String reccValues) {
		this.reccValues = reccValues;
	}

	public ReccIn(Integer userId, @NotNull @Size(max = 100) String reccValues) {
		super();
		this.userId = userId;
		this.reccValues = reccValues;
	}

	protected ReccIn() {
		
	}
}

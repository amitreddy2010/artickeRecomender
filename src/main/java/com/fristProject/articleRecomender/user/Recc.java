package com.fristProject.articleRecomender.user;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fristProject.articleRecomender.post.Post;

//@JsonIgnoreProperties(value = {"orgnization"})
@Entity
@Table(name = "recc_table")
public class Recc {
//	@GeneratedValue
	@Id
	private Integer title_id;
	//validation min car
	
	@NotNull
    @Size(max = 100)
    private String recc_fields;

	public Integer getTitle_id() {
		return title_id;
	}

	public void setTitle_id(Integer title_id) {
		this.title_id = title_id;
	}

	public String getRecc_fields() {
		return recc_fields;
	}

	public void setRecc_fields(String recc_fields) {
		this.recc_fields = recc_fields;
	}

	public Recc(Integer title_id, @NotNull @Size(max = 100) String recc_fields) {
		super();
		this.title_id = title_id;
		this.recc_fields = recc_fields;
	}
	
	protected Recc() {
		
	}

	
}
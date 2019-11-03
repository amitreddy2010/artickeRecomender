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
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	//validation min car
	
	@NotNull
    @Size(max = 100)
    @NaturalId
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "post_user",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "post_id") })
    private Set<Post> posts = new HashSet<>();

	public User(Integer id, @NotNull @Size(max = 100) String name, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.posts = posts;
	}
	
	public User( @NotNull @Size(max = 100) String name) {
		super();
		this.name = name;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	protected User() {
		
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

}

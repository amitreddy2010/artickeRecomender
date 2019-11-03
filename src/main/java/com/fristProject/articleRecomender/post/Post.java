package com.fristProject.articleRecomender.post;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fristProject.articleRecomender.user.User;

import io.micrometer.core.instrument.Tag;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();


	@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "posts")
    private Set<User> users = new HashSet<>();


    public Post() {

    }

	public Post(@NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
			@NotNull String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}
	
	public Post(Long id, @NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
			@NotNull String content, @NotNull Date postedAt, @NotNull Date lastUpdatedAt, Set<User> users) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.postedAt = postedAt;
		this.lastUpdatedAt = lastUpdatedAt;
		this.users = users;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}

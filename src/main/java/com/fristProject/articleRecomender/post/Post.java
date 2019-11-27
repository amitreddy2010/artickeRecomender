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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 250)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 1000)
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

    @Column(name = "fund_type")
    private String fundType;
	
    @Column(name = "curr")
    private String curr;

    @Column(name = "geo_focus")
    private String geoFocus;
    
    @Column(name = "month3_performance")
    private String month3Performance;  
    @Column(name = "month6_performance")
    private String month6Performance;  
    @Column(name = "year1_performance")
    private String year1Performance;  
    @Column(name = "year3_performance")
    private String year3Performance;  
    
    public Post() {

    }

	public Post(Integer id,@NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
			@NotNull String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	
	public Post(Integer id, @NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
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




	public Post(Integer id, @NotNull @Size(max = 250) String title, @NotNull @Size(max = 1000) String description,
			@NotNull String content,
			String fundType, String curr, String geoFocus, String month3Performance, String month6Performance,
			String year1Performance, String year3Performance) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
//		this.postedAt = postedAt;
//		this.lastUpdatedAt = lastUpdatedAt;
//		this.users = users;
		this.fundType = fundType;
		this.curr = curr;
		this.geoFocus = geoFocus;
		this.month3Performance = month3Performance;
		this.month6Performance = month6Performance;
		this.year1Performance = year1Performance;
		this.year3Performance = year3Performance;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public String getGeoFocus() {
		return geoFocus;
	}

	public void setGeoFocus(String geoFocus) {
		this.geoFocus = geoFocus;
	}

	public String getMonth3Performance() {
		return month3Performance;
	}

	public void setMonth3Performance(String month3Performance) {
		this.month3Performance = month3Performance;
	}

	public String getMonth6Performance() {
		return month6Performance;
	}

	public void setMonth6Performance(String month6Performance) {
		this.month6Performance = month6Performance;
	}

	public String getYear1Performance() {
		return year1Performance;
	}

	public void setYear1Performance(String year1Performance) {
		this.year1Performance = year1Performance;
	}

	public String getYear3Performance() {
		return year3Performance;
	}

	public void setYear3Performance(String year3Performance) {
		this.year3Performance = year3Performance;
	}

	
}

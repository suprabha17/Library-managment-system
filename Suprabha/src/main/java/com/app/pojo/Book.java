package com.app.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "book")
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "availability_count")
    private Integer availabilityCount;

    @Column(name = "author")
    private String  author;

    
    @UpdateTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate    
    @Column(name = "updated_at")
    private Date updatedAt;

    public Book()
    {
    	
    }
    public Book(   String title2, String getauthor, Integer availabilityCount2) {
    	title=title2;
    	author=getauthor;
    	availabilityCount=availabilityCount2;
	}
    
    

	public Book(Integer id, String title, @NotNull Integer availabilityCount, String author) {
		super();
		this.id = id;
		this.title = title;
		this.availabilityCount = availabilityCount;
		this.author = author;
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

    public Integer getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(Integer availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

//    @Override
//    public String toString() {
//        return new Gson().toJson(this);
//    }
}

package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.app.Enums.Roles;

@Entity
@Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",length = 30)
    private String name;

    @Column(name = "role")
    @Enumerated
    private Roles role;

    @Column(name = "created_at")
    @UpdateTimestamp
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDate updatedAt;

    @Column(name = "fine",length = 30)
    private Float fine;

    @Column(name = "num_of_books_present",length = 30)
    private Integer numOfBooksPresent;
    
    @Column(name="email",unique = true,length = 30)
    private String email;
    
    @Column(name="password",length = 30)
    private String password;

    @Column(name="address",length = 30)
    private String address;

	public User(Integer id, String name, LocalDate createdAt, LocalDate updatedAt, Float fine, Integer numOfBooksPresent,
			String email, String password, String address,Roles role) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.fine = fine;
		this.numOfBooksPresent = numOfBooksPresent;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role=role;
	}

	public User() {
		super();
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Float getFine() {
		return fine;
	}

	public void setFine(Float fine) {
		this.fine = fine;
	}

	public Integer getNumOfBooksPresent() {
		return numOfBooksPresent;
	}

	public void setNumOfBooksPresent(Integer numOfBooksPresent) {
		this.numOfBooksPresent = numOfBooksPresent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
    
    

    
}

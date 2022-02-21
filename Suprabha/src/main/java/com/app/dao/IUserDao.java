package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.User;

public interface IUserDao extends JpaRepository<User,Integer> {

	List<User> findByEmail(String email);
    
	//List<ProjectIdAndName> findAll();
	
}

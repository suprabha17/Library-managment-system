package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Book;

public interface IBookDao extends JpaRepository<Book,Integer> {

	List<Book> findByAuthor(String author);

	Book findByTitle(String title);

	
	
	
}

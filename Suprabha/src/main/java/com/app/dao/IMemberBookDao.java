package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.BookIdMemberMapping;

public interface IMemberBookDao extends JpaRepository<BookIdMemberMapping,Integer>{
	BookIdMemberMapping findByBookId(Integer bookId);
       List<BookIdMemberMapping> findByMemberId(Integer memberId);
       BookIdMemberMapping findByBookIdAndMemberId(Integer bookId,Integer memberId);
}

package com.app.service;

import java.util.List;

import com.app.dto.MemberDto;
import com.app.pojo.Book;
import com.app.pojo.User;

public interface IMemberService {
	User addMemberDetails(MemberDto memberdto);
    void issueBook(Integer bookId,Integer memberId);
    void renewBook(Integer bookId,Integer memberId);
    void updateMemberAdd(Integer Id,String add);
    void updatePassword(String email,String pass);
    void fineToPay(Integer issueId,Float fine);
    List<Book> allBooks();
    User validateUser(String email, String pwd);
}

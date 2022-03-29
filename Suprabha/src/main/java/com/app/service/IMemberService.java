package com.app.service;

import java.util.List;

import com.app.dto.Login;
import com.app.dto.MemberDto;
import com.app.pojo.Book;
import com.app.pojo.User;

public interface IMemberService {
	User addMemberDetails(MemberDto memberdto);
   
    void renewBook(Integer bookId,Integer memberId);
    void updateMemberAdd(Integer Id,String add);
    void updatePassword(String email,String pass);
    String fineToPay(Integer issueId);
    List<Book> allBooks();
    User validateUser(Login details);
    void bookReserve(int memberId,int bookId);
}

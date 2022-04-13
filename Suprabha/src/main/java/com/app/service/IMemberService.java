package com.app.service;

import java.util.List;

import com.app.dto.Login;
import com.app.dto.MemberDto;
import com.app.dto.UpdatePAss;
import com.app.pojo.Book;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;

public interface IMemberService {
	User addMemberDetails(MemberDto memberdto);
   
    String renewBook(Integer bookId,Integer memberId);
    void updateMemberAdd(Integer Id,String add);
    User updatePassword(UpdatePAss details);
    String fineToPay(Integer issueId);
    List<Book> allBooks();
    User validateUser(Login details);
    void bookReserve(int memberId,int bookId);
    List<Book> availableBook(); 
    User updateUser(User user);
    List<BookIdMemberMapping> bookForReturn();
}

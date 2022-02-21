package com.app.service;

import java.util.List;

import com.app.dto.BookDto;
import com.app.dto.MemberDto;
import com.app.pojo.Book;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;

public interface ILibrarianService {
	
	Book addBooks(BookDto  bookDtoList) ;//added not yet checked
	
     List<Book> getAllBooks();  //done
//     Book getBookById(int id);
     void deleteBook(Integer deletebook);  //added not working
     Book getBookById(Integer bookIds);          //added
     void updateBookQty(Integer bookId,Integer qty);  //yes it is working
     //issue book
     void issueBook(Integer bookId, Integer memberId);//added
     List<User> getAllMember();
     //book renew 
     void renewBook(Integer bookId, Integer memberId);//
     String delete(Integer memberId);// added
     List<Book> findByAuthor(String author);  //added
     Book findByTitle(String title);//added
     String returnBook(Integer issueId);  //added
     void updateMemberFine(Integer memberId, Float amount);
     //List<BookIdMemberMapping> bookForFine();
     List<BookIdMemberMapping> getAllissueBook();//added
     
     
}

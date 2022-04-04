package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.constant.Constants;
import com.app.dao.IBookDao;
import com.app.dao.IMemberBookDao;
import com.app.dao.IUserDao;
import com.app.dto.BookDto;
import com.app.dto.IssueBook;
import com.app.exception.DependanceyException;
import com.app.exception.RecordNotFound;
import com.app.pojo.Book;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;



@Service
@Transactional
public class LibrarianServiceImpl implements ILibrarianService
{
   @Autowired
   private IBookDao bdao;
   @Autowired
	private EntityManager manager;
   @Autowired
   private IUserDao mdao;
   @Autowired
   private IMemberBookDao bmdao;
   
   public LibrarianServiceImpl ()
   {
	   System.out.println("in librian dao");
   }
   
@Override
public Book addBooks(BookDto bookDtoList) {
	
		
	return bdao.save(new Book(bookDtoList.getTitle(),
			bookDtoList.getauthor(),1));
		
	
}


@Override
public List<Book> getAllBooks() {
	
	return bdao.findAll();
}

@Override
public void deleteBook(Integer deletebook) {	
	
	
	System.out.println("in book delet impl***");
	Optional<Book> book=bdao.findById(deletebook);
	if(book.get().getAvailabilityCount()==1)
		bdao.deleteById(deletebook);
	else
		throw new DependanceyException("book is issued cannot remove");
	
	
}



@Override
public Book getBookById(Integer bookId) {
	
	return bdao.findById(bookId).orElseThrow(()->new RecordNotFound("this book is not available"));
              //added .get(0) because return type is list to make it Book object taking input 
	            //at 0th index
	
}

@Override
public Book updateBook(Book book1) 
{
//	Book b=new Book();
//	b.setTitle(book1.getTitle());
//	b.setAvailabilityCount(book1.getAvailabilityCount());
//	b.setauthor(book1.getauthor());
//	
	return bdao.save(book1);
	
}


@Override
public void issueBook(IssueBook issubook) {
	System.out.println("in issue book method innn");
	 User member=(mdao.findById(issubook.getMemberId())).get();
	 System.out.println("????");
            	Book book=(bdao.findById(issubook.getBookId())).get();
            	
            	
               
                System.out.println("in issue boook section****");
//       	if(member.getNumOfBooksPresent()>4)
//    	{
//    		throw new DependanceyException("Max books already issued .");
//    	}else if(member.getFine()!=0)
//    	{
//    		System.out.println(member.getFine()+"-----fine");
//    		throw new DependanceyException("Fine is not cleared yet");
//    	}else
//    	{
    		Integer numberOfBookPresent=member.getNumOfBooksPresent();
    		numberOfBookPresent +=numberOfBookPresent;
    		member.setNumOfBooksPresent(numberOfBookPresent);
    		
    		Integer qty=book.getAvailabilityCount();
    		qty-=qty;
    		book.setAvailabilityCount(qty);
    		bdao.save(book);
    		BookIdMemberMapping issue=new BookIdMemberMapping();
    		issue.setBookId(issubook.getBookId());
    		issue.setMemberId(issubook.getMemberId());
    		issue.setIssuedOn(LocalDate.now());
    		issue.setExpectedReturn(LocalDate.now().plusDays(7));
    		issue.setFineOnBook(Constants.INITIAL_FINE_FOR_MEMBER);
    		issue.setNumOfTimesRenewed(Constants.INITIAL_RENEW_TIME);
    		issue.setReservation(0);
    		issue.setReturnDate(null);
    		issue.setRenewedAt(null);
    		bmdao.save(issue);
    		mdao.save(member);
    		
    		
//    	}
	
	
}


@Override
public void renewBook(Integer bookId, Integer memberId) {
	if(!bdao.findById(bookId).isPresent())
	{
		throw new RecordNotFound("no book with given Id"+bookId);
	}
	if(!mdao.findById(memberId).isPresent())
	{
		throw new RecordNotFound("no member with given Id"+memberId);
	}
	int noOftimeRenew =bmdao.findByBookIdAndMemberId(bookId,memberId).get(0).getNumOfTimesRenewed();
	if(noOftimeRenew==Constants.MAX_RENEWAL)
	{
		throw new DependanceyException("this book has been renewed by max no of times");
	}else
	{
		Float fine=mdao.findById(memberId).get().getFine();
		if(fine>0)
		{
			throw new DependanceyException("User has been charged fine. Please pay and renew books");
		}else
		{
			List<BookIdMemberMapping> bmmapping1 =
					bmdao.findByBookIdAndMemberId(bookId,memberId);
			BookIdMemberMapping bmmapping=bmmapping1.get(0);
			int noOfRenew=bmmapping.getNumOfTimesRenewed();
			bmmapping.setNumOfTimesRenewed(noOfRenew++);
			
			bmmapping.setReturnDate(LocalDate.now());
			bmdao.save(bmmapping);
			System.out.println("renewed successfuly");
		}
	}
	
	
	
	
	
	
}

@Override
public String delete(Integer memberId) {
	
	     
	         
	        	 mdao.deleteById(memberId);
	        	 return "deleted successfuly";
	        
}

@Override
public List<Book> findByAuthor(String author) {
	
	List<Book> book=bdao.findByAuthor(author);
	return book;
}

@Override
public Book findByTitle(String title) {
	Book book =bdao.findByTitle(title);
	return book;
}

@Override
public String returnBook(Integer issueId) {
	
	System.out.println(issueId+"*********");
	BookIdMemberMapping issuedBook= bmdao.findById(issueId).orElseThrow(()->new RecordNotFound("this book is not issued"));
	
	          User member=mdao.findById(issuedBook.getMemberId()).orElseThrow(()->new RecordNotFound("this book is not issued"));
	           if(member.getFine()!=0)
                  throw new DependanceyException("Fine is not cleared yet");  
                  else
                  {
                	 
                	  issuedBook.setReturnDate(LocalDate.now());
                	          Integer bookId=issuedBook.getBookId();
                	        Book book  =bdao.findById(bookId).orElseThrow(()->new RecordNotFound("this book is not issued"));
                	        book.setAvailabilityCount(book.getAvailabilityCount()+1);
                     int n= member.getNumOfBooksPresent();
                     member.setNumOfBooksPresent(n--);
       	           bmdao.save(issuedBook);
       	           mdao.save(member);
       	           return "returned book successfuly";
                  }
}

//fine added into the member account
@Override
public String updateMemberFine(Integer issueId)

{
	float amount =10;
	BookIdMemberMapping issueBook=bmdao.findById(issueId).orElseThrow(()->new RecordNotFound("book not found"));
    User member=mdao.findById(issueBook.getMemberId()).orElseThrow(()->new RecordNotFound("member not found"));
   
	   float amt=issueBook.getFineOnBook();
	   float amt1=member.getFine();
	   issueBook.setFineOnBook(amount+amt);
	   member.setFine(amount+amt1);
	    bmdao.save(issueBook);
	    mdao.save(member);
	    return "fine updated";
   
}
//*******************************
@Override
public List<BookIdMemberMapping> bookForFine()
{
	
	
	return bmdao.findByExpectedReturn(LocalDate.now());
	
}

@Override
public List<BookIdMemberMapping> getAllissueBook() {
	 System.out.println("in all issue book");
	return bmdao.findAll();
}



@Override
public List<User> getAllMember() {
	
	return mdao.findAll();
	
}

@Override
public List<BookIdMemberMapping> getIssueBookOfMemebr(Integer memberId) {
	
	
	       List<BookIdMemberMapping> issuebooks=bmdao.findByMemberId(memberId);
	       List<BookIdMemberMapping> allIssue= new ArrayList<BookIdMemberMapping>();
	       for(BookIdMemberMapping r:issuebooks )
	       {
	    	   if(r.getReturnDate()==null)
	    		   allIssue.add(r);
	    	   
	       }
		return allIssue;
}



@Override
public List<BookIdMemberMapping> getAllissueBookForReservation() {
	     List<BookIdMemberMapping> issueBook = bmdao.findAll();
	     List<BookIdMemberMapping> allIssue= new ArrayList<BookIdMemberMapping>();
	       for(BookIdMemberMapping r:issueBook )
	       {
	    	   if(r.getReturnDate()==null)
	    		   allIssue.add(r);
	    	   
	       }
		return allIssue;
	
}

@Override
public User getByMemberId(Integer memberId) {

	return mdao.findById(memberId).orElseThrow(()->new RecordNotFound("member not found"));
}













   
   
}

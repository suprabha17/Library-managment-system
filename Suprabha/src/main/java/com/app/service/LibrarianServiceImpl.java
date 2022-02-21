package com.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.constant.Constants;
import com.app.dao.IBookDao;
import com.app.dao.IMemberBookDao;
import com.app.dao.IUserDao;
import com.app.dto.BookDto;
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
   private IUserDao mdao;
   @Autowired
   private IMemberBookDao bmdao;
   
   public LibrarianServiceImpl ()
   {
	   System.out.println("in librian dao");
   }
   
@Override
public Book addBooks(BookDto bookDtoList) {
	/*
	 * Consumer<BookDto> bookdtoconsumer=bookdto-> { Book book=new Book();
	 * book.setTitle(bookdto.getTitle()); book.setauthor(bookdto.getauthor());
	 * book.setAvailabilityCount(bookdto.getAvailabilityCount()); //for logger
	 */		
	return bdao.save(new Book(bookDtoList.getTitle(),bookDtoList.getauthor(),bookDtoList.getAvailabilityCount()));
		//bdao.save(book);
		//for logger
		
		
////interface ProjectIdAndName{
//    String getId();
//    String getName();
//}
//	
	
}


@Override
public List<Book> getAllBooks() {
	//updated by sonali
	//b1--object
	//string name=b1.get(0);
	return bdao.findAll();
}

@Override
public void deleteBook(Integer deletebook) {	
	//while deleting a book , we need to check if this book is associated with any member.
    //if this book is associated with any scholar, then deletion cannot be performed
//	Integer bookIdList= deletebook;
//	Consumer<Integer> bookIDConsumer=bookId->{
//		Optional<Book> optional=(bdao.findById(bookId));
//		if(optional.isPresent())
//		{
//			//here checking is book issued.
//			Optional<List<BookIdMemberMapping>> optional1=
//					Optional.ofNullable(bmdao.findByBookId(bookId));
//			        if(optional1.isPresent())
//			        {
//			throw new DependanceyException("Book can't be deleted, because it is issued");
//		  }
//			        System.out.println("deleteing Book by id"+bookId);
//			        bdao.deleteById(bookId);
//			        System.out.println("deleted successfully");
//       }
//		else
//       {
//    	   System.out.println("book with id not found");
//    	   throw new RecordNotFound("this book is not available..");
//       }
//		
//	};
	
	System.out.println("in book delet impl***");
	BookIdMemberMapping issueBook=bmdao.findByBookId(deletebook);
	if(issueBook.getreturnDate()!=null)
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
public void updateBookQty(Integer bookId, Integer qty) 
{
	Optional<Book> optionalBook=bdao.findById(bookId);
	if(optionalBook.isPresent())
	{
		Book book=optionalBook.get();
		Integer avlCount=book.getAvailabilityCount();
		avlCount+=qty;
		book.setAvailabilityCount(avlCount);
		bdao.save(book);
	}
	else
	{
		throw new RecordNotFound("Book not available");
	}
	
}


@Override
public void issueBook(Integer bookId, Integer memberId) {
	bdao.findById(bookId)
	.orElseThrow(()-> new RecordNotFound("book with givin Id not found"));
	mdao.findById(memberId).ifPresentOrElse(
    member->{
    	if(member.getNumOfBooksPresent()>4)
    	{
    		throw new DependanceyException("Max books already issued .");
    	}else if(member.getFine()!=Constants.INITIAL_FINE_FOR_MEMBER)
    	{
    		throw new DependanceyException("Fine is not cleared yet");
    	}else
    	{
    		int numberOfBookPresent=member.getNumOfBooksPresent();
    		member.setNumOfBooksPresent(numberOfBookPresent++);
    		
    	}
    	 Consumer<Book>bookConsumer = book -> {
             Integer presentBooksAtLib = book.getAvailabilityCount();
             if(presentBooksAtLib>0)
             book.setAvailabilityCount(presentBooksAtLib--);
             else
            	 throw new DependanceyException("Book not present in library");
    	};
    	bdao.findById(bookId).ifPresent(bookConsumer);
    	mdao.save(member);
    	BookIdMemberMapping bmmapping=new BookIdMemberMapping();
    	bmmapping.setMemberId(memberId);
    	bmmapping.setBookId(bookId);
    	bmmapping.setIssuedOn(new Date());
    	bmdao.save(bmmapping);
    }, ()->{
    	new RecordNotFound("member with givin Id is not found");
    });
	BookIdMemberMapping bmmapping=new BookIdMemberMapping();
	bmmapping.setMemberId(memberId);
	bmmapping.setBookId(bookId);
	bmmapping.setIssuedOn(new Date());
	bmdao.save(bmmapping);
	
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
	int noOftimeRenew =bmdao.findByBookIdAndMemberId(bookId,memberId).getNumOfTimesRenewed();
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
			BookIdMemberMapping bmmapping =
					bmdao.findByBookIdAndMemberId(bookId,memberId);
			int noOfRenew=bmmapping.getNumOfTimesRenewed();
			bmmapping.setNumOfTimesRenewed(noOfRenew++);
			bmmapping.setrenewedAt(new Date());
			bmdao.save(bmmapping);
			System.out.println("renewed successfuly");
		}
	}
	
	
	
	
	
	
}

@Override
public String delete(Integer memberId) {
	List<BookIdMemberMapping> issuemeber=bmdao.findByMemberId(memberId);
	     
	         if(issuemeber.get(0).getreturnDate()!=null)
	         {
	        	 mdao.deleteById(memberId);
	        	 return "deleted successfuly";
	         }
	         else
	        	 throw new DependanceyException("cannot remove this member because he/she have book to return");
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
	
	BookIdMemberMapping issuedBook= bmdao.findById(issueId).orElseThrow(()->new RecordNotFound("this book is not issued"));
	
	          User member=mdao.findById(issuedBook.getMemberId()).orElseThrow(()->new RecordNotFound("this book is not issued"));
	           if(member.getFine()!=Constants.INITIAL_FINE_FOR_MEMBER)
                  throw new DependanceyException("Fine is not cleared yet");  
                  else
                  {
                	  issuedBook.setreturnDate(new Date());
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
public void updateMemberFine(Integer issueId, Float amount) 
{
	BookIdMemberMapping issueBook=bmdao.findById(issueId).orElseThrow(()->new RecordNotFound("book not found"));
    User member=mdao.findById(issueBook.getMemberId()).orElseThrow(()->new RecordNotFound("member not found"));
   if(issueBook.getExpectedReturn().isBefore(LocalDate.now()))
   {
	   issueBook.setFineOnBook(amount);
	   member.setFine(amount);
	   mdao.save(member);
	    bmdao.save(issueBook);
   }
   else
	   throw new DependanceyException("cannot add fine on it");
}
//*******************************
//@Override
//public List<BookIdMemberMapping> bookForFine()
//{
//	List<BookIdMemberMapping> issueBook=bmdao.findBy
//	//select * from BookIdMemberMapping where expected return date=now();
//	return ;
//}

@Override
public List<BookIdMemberMapping> getAllissueBook() {
	 
	return bmdao.findAll();
}

@Override
public List<User> getAllMember() {
	
	return mdao.findAll();
	
}













   
   
}

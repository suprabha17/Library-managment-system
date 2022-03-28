package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.dto.IssueBook;
import com.app.exception.CustomRuntimeException;
import com.app.pojo.Book;
import com.app.pojo.BookIdMemberMapping;
import com.app.service.ILibrarianService;
import com.app.service.LibrarianServiceImpl;

@RestController
@RequestMapping("/libr")

public class LibrarianController {

	@Autowired
	private ILibrarianService labService;
	
	
	@Autowired
	private LibrarianServiceImpl limplser;
	
	
	public LibrarianController()
	{
	   System.out.println("in controller");
	}
	
	
	//add book  **working
	@PostMapping("/Book")
	public Book addBook(@Valid @RequestBody BookDto bookdto)
	{
		return limplser.addBooks(bookdto);

	
	}
	
	
	@GetMapping("/")  //***passed
		public ResponseEntity<?> allBook()
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getAllBooks(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  
	  //get single book by id*****passed
	  @GetMapping("/{bookId}")
		public ResponseEntity<?> getBookById(@PathVariable Integer bookId)
		{
			try {
			
			return new ResponseEntity<>(labService.getBookById(bookId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  //delete book by id
	  // working!!!
	    @DeleteMapping("/{bookId}")
		public void deleteBookById(@PathVariable Integer bookId)
		{
			System.out.println("in delete");
		  labService.deleteBook(bookId);
		}
	  
	  //update book qty
	  //checked
	  @PutMapping("/{bookId}") //working
	  public void updateBookQtyplus(@PathVariable Integer bookId )
	  {
		  labService.updateBookQty(bookId, 1);
	  }
	  
	  
	  @GetMapping("/member") ///workikng!!!
	  public ResponseEntity<?> allMembers()
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getAllMember(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  @GetMapping("/issuebook") //working
	  public ResponseEntity<?> allIssueBook()
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getAllissueBook(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  
	  @PostMapping("/issue")   //working
		public void issueBook( @RequestBody IssueBook issuebook)
		{
		    System.out.println("in issue book ****");
			labService.issueBook(issuebook);
			
		}
	  
	  //issuebook of member by memberID
	  
	  @GetMapping("/issuebook/{memberId}")//working
	  public ResponseEntity<?> issueBookOfMemebr(@PathVariable Integer memberId)
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getIssueBookOfMemebr(memberId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  @PutMapping("/issuebook/{issuebookId}")//working
	  public ResponseEntity<?> returnBookIssued(@PathVariable Integer issuebookId)
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.returnBook(issuebookId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  
	  @DeleteMapping("/member/{memberId}") //working
	  
	  public ResponseEntity<?> deleteMember(@PathVariable Integer memberId)
		{
			try {
			
			return new ResponseEntity<>(labService.delete(memberId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  @GetMapping("/author/{author}")  //working
	   
	  public ResponseEntity<?> serchByAuthor(@PathVariable String author)
		{
		  System.out.println("in serch author ");
			try {
			
			return new ResponseEntity<>(labService.findByAuthor(author), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	  @GetMapping("/title/{title}")//working
	   
	  public ResponseEntity<?> serchByTitle(@PathVariable String title)
		{
		  System.out.println("in search title");
			try {
			
			return new ResponseEntity<>(labService.findByTitle(title), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  @GetMapping("/issue/{issueId}") //working
	  public ResponseEntity<?> serchById(@PathVariable Integer issueId)
		{
			try {
			
			return new ResponseEntity<>(labService.returnBook(issueId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	  
	  @GetMapping("/fineOn") //working
	  public ResponseEntity<?> bookForFines()
		{
			try {
			
			return new ResponseEntity<>(labService.bookForFine(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  
	  @PutMapping("/fineOn/{issueId}") //working fine
	  public ResponseEntity<?>  addingFines(@PathVariable Integer issueId)
		{
			try {
			
			return new ResponseEntity<>(labService.updateMemberFine(issueId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  //renew,fine pay,login,reservation
	
}

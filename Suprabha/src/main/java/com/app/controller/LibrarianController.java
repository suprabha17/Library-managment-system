package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.app.pojo.User;
import com.app.service.ILibrarianService;
import com.app.service.IMemberService;
import com.app.service.LibrarianServiceImpl;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/libr")

public class LibrarianController {

	@Autowired
	private ILibrarianService labService;
	
	
	@Autowired
	private IMemberService mservice;
	
	
	
	public LibrarianController()
	{
	   System.out.println("in controller");
	}
	
	
	//add book  **working
	@PostMapping("/Book")
	public Book addBook( @RequestBody BookDto bookDtoList)
	{
		System.out.println(bookDtoList.getTitle());
		System.out.println(bookDtoList.getAvailabilityCount());
		System.out.println(bookDtoList.getauthor());
		return labService.addBooks(bookDtoList);

	
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
	  //working
	  
	  @PutMapping("/booktoupdate")  ///workikng!!!
	  public ResponseEntity<?>  updateBook(@RequestBody Book book )
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.updateBook(book), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
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
	  
	  
	  @PostMapping("/issue/{memberId}/{bookId}")   //working
		public void issueBook( @PathVariable Integer memberId,@PathVariable Integer bookId)
		{
		  System.out.println(memberId+"*******"+bookId);
		  IssueBook issue1=new IssueBook(bookId, memberId);
		    System.out.println("in issue book ****");
			labService.issueBook(issue1);
			
		}
	  
	  //issuebook of member by memberID
	  
	  @GetMapping("/issuebook/{memberId}")//working
	  public ResponseEntity<?> issueBookOfMemebr(@PathVariable Integer memberId)
		{
		System.out.println("issue book of member");
			try {
			
			return new ResponseEntity<>(labService.getIssueBookOfMemebr(memberId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  @PutMapping("/issuebook/{issuebookId}")//working
	  public ResponseEntity<?> returnBookIssued(@PathVariable Integer issuebookId)
		{System.out.println(issuebookId);
		System.out.println("in return");
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
	  
	  @PutMapping("/member")
	  
	  public ResponseEntity<?> UpdateMember(@RequestBody User user)
		{
			try {
			
			return new ResponseEntity<>(mservice.updateUser(user), HttpStatus.OK);
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
			   System.out.println(author);
			return new ResponseEntity<>(labService.findByAuthor(author), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	  @GetMapping("/title/{title}")//working
	   
	  public ResponseEntity<?> serchByTitle(@PathVariable String title)
		{
		  System.out.println(title);
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
	  
	  @GetMapping("/member/{memberId}")
	  public ResponseEntity<?>  memberDetails(@PathVariable Integer memberId)
		{
			try {
			
			return new ResponseEntity<>(labService.getByMemberId(memberId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  //renew,fine pay,login,reservation
	
}

package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.IssueBook;
import com.app.dto.Login;
import com.app.dto.MemberDto;
import com.app.exception.CustomRuntimeException;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;
import com.app.service.LibrarianServiceImpl;
import com.app.service.MemberServiceImpl;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberServiceImpl mservice;
	
	@Autowired
	private LibrarianServiceImpl labService;
	
	@PostMapping("/add")
		
	public User registration(@Valid @RequestBody MemberDto memberdto)
	{
		return mservice.addMemberDetails(memberdto);
	}
	
	
	 @PostMapping("/author")  //working
	   
	  public ResponseEntity<?> serchByAuthor(@RequestBody String author)
		{
		  System.out.println("in serch author ");
			try {
			
			return new ResponseEntity<>(labService.findByAuthor(author), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	  @PostMapping("/title")//working
	   
	  public ResponseEntity<?> serchByTitle(@RequestBody String title)
		{
		  System.out.println("in search title");
			try {
			
			return new ResponseEntity<>(labService.findByTitle(title), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  
	  @GetMapping("/issuebook") //working for reservation
	  public ResponseEntity<?> allIssueBook()
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getAllissueBookForReservation(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  @PutMapping("/renew/{memberId}/{bookId}")   //working
		public ResponseEntity<?> renewBook( @PathVariable Integer memberId,@PathVariable Integer bookId)
		{
		  System.out.println("in renew");
			try {
			
			return new ResponseEntity<>(mservice.renewBook(bookId, memberId), HttpStatus.OK);
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
	  public ResponseEntity<?> allMembers(@PathVariable Integer memberId)
		{
		System.out.println("in allBook");
			try {
			
			return new ResponseEntity<>(labService.getIssueBookOfMemebr(memberId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  	  
	  
	  
	  
	@GetMapping("/books")
	
	   
	  public ResponseEntity<?> allBooks()  
		{
		  System.out.println("in member all books method");
			try {
			
			return new ResponseEntity<>(mservice.allBooks(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	
	@GetMapping("/availableBooks")
	
	   
	  public ResponseEntity<?> availableBooks()  
		{
		  System.out.println("in member all books method");
			try {
			
			return new ResponseEntity<>(mservice.availableBook(), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	@PostMapping("/login")
	public ResponseEntity<?> userValidation(@RequestBody Login details)
	{
	  System.out.println("in member login");
		try {
		
		return new ResponseEntity<>(mservice.validateUser(details), HttpStatus.OK);
		
		}catch(CustomRuntimeException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
	}
	
	@PutMapping("/issuebook/{issueId}")  //working
	
	public ResponseEntity<?> userValidation(@PathVariable Integer issueId)
	{
	  System.out.println("fine pay");
		try {
		
		return new ResponseEntity<>(mservice.fineToPay(issueId), HttpStatus.OK);
		}catch(CustomRuntimeException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
	}
	
	@GetMapping("/returnBook")
	public ResponseEntity<?> returnBook()
	{
	  System.out.println("return book");
		try {
		
		return new ResponseEntity<>(mservice.bookForReturn(), HttpStatus.OK);
		}catch(CustomRuntimeException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
	}
	
	
}

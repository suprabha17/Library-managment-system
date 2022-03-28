package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.IssueBook;
import com.app.dto.MemberDto;
import com.app.exception.CustomRuntimeException;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;
import com.app.service.LibrarianServiceImpl;
import com.app.service.MemberServiceImpl;

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
	
	
	
	@GetMapping("/validate")
	public ResponseEntity<?> userValidation(@RequestBody String email,String pass )
	{
	  System.out.println("in member all books method");
		try {
		
		return new ResponseEntity<>(mservice.validateUser(email,pass), HttpStatus.OK);
		}catch(CustomRuntimeException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
	}
	
	
}

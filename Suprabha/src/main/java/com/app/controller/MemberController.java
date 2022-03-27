package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MemberDto;
import com.app.exception.CustomRuntimeException;
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
	  
	  
	  @PostMapping("/issue")
		public ResponseEntity<?> issueBook(@Valid @RequestBody Integer bookId,Integer memberId)
		{
			try {
			labService.issueBook(bookId, memberId);
			return new ResponseEntity<>("status", HttpStatus.OK);
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

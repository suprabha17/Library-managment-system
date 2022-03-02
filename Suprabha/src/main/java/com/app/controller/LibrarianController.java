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
import com.app.exception.CustomRuntimeException;
import com.app.pojo.Book;
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
	public Book/*ResponseEntity<?>*/ addBook(@Valid @RequestBody BookDto bookdto)
	{
		return limplser.addBooks(bookdto);
//		try {
//			
//		return new ResponseEntity<>(limplser.addBooks(bookdto), HttpStatus.OK);
//		}catch(CustomRuntimeException e)
//		{
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
//		}
	
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
	  @PutMapping("/{bookId}")
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
	  
	  @GetMapping
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
	  @GetMapping("/aythor/{author}")  //working
	   
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
	  
	  @PutMapping("/issue/{issueId}")
	  public ResponseEntity<?> serchByTitle(@PathVariable Integer issueId)
		{
			try {
			
			return new ResponseEntity<>(labService.returnBook(issueId), HttpStatus.OK);
			}catch(CustomRuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	
}

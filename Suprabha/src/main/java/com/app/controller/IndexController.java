package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Login;
import com.app.dto.MemberDto;
import com.app.exception.CustomRuntimeException;
import com.app.pojo.User;
import com.app.service.LibrarianServiceImpl;
import com.app.service.MemberServiceImpl;

@RestController
@RequestMapping("/")
public class IndexController {
	@Autowired
	private MemberServiceImpl mservice;
	
	@Autowired
	private LibrarianServiceImpl labService;
	@PostMapping("register")
	
	public User registration(@Valid @RequestBody MemberDto memberdto)
	{
		return mservice.addMemberDetails(memberdto);
	}
	
	
	@GetMapping("login")
	public ResponseEntity<?> userValidation(@RequestBody Login details )
	{
	  System.out.println("in member login");
		try {
		
		return new ResponseEntity<>(mservice.validateUser(details), HttpStatus.OK);
		}catch(CustomRuntimeException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
	}
}

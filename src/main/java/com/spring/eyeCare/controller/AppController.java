package com.spring.eyeCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.eyeCare.model.User;

@RestController

public class AppController {
	@Autowired
	private AuthenticationManager authManager;
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}
	
	@PostMapping(value ="/login",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.ALL_VALUE})
	public ResponseEntity<HttpStatus> login(@RequestBody User user){
		System.out.println(user.getUserName()+" "+user.getPassword());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
		Authentication authObject= authManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authObject);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}

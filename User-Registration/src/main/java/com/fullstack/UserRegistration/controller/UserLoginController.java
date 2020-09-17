package com.fullstack.UserRegistration.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.UserRegistration.dto.RegistrationVO;
import com.fullstack.UserRegistration.dto.ResultVO;
import com.fullstack.UserRegistration.services.impl.UserLoginService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	//@PostMapping("/register",)
	//@PostMapping(value ="/register",headers = {"content-type = multipart/form-data"} )
	@RequestMapping(value = "/register", headers = {"Content-Type= multipart/form-data"}, consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResultVO> createUser(@Validated  @ModelAttribute RegistrationVO regVO,BindingResult result) throws IOException {
		
		return userLoginService.createUser(regVO);
	}
	@PostMapping("/login")
	public ResponseEntity<ResultVO> loginUser( @RequestBody RegistrationVO regVO) throws IOException {
		
		return userLoginService.loginUser(regVO);
	}

}

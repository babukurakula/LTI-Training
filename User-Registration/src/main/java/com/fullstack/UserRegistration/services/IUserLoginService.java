package com.fullstack.UserRegistration.services;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.fullstack.UserRegistration.dto.RegistrationVO;
import com.fullstack.UserRegistration.dto.ResultVO;

public interface IUserLoginService {
	
	public ResponseEntity<ResultVO> createUser(RegistrationVO regVO) throws IOException ;

}

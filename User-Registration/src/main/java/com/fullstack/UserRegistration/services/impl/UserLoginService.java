package com.fullstack.UserRegistration.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;

import com.fullstack.UserRegistration.dto.RegistrationVO;
import com.fullstack.UserRegistration.dto.ResultVO;
import com.fullstack.UserRegistration.model.User;
import com.fullstack.UserRegistration.repository.UserRepository;
import com.fullstack.UserRegistration.services.IUserLoginService;

@Service
public class UserLoginService implements IUserLoginService {
	
	@Autowired
	private UserRepository userRepo;
	
	public ResponseEntity<ResultVO> createUser(RegistrationVO regVO) throws IOException {
			List<User> users  = userRepo.findByUserNameAndIsActiveAndIsDeleted(regVO.getUserName().trim(), "Y", "N");
			if(users != null && !users.isEmpty()) {
				ResultVO resVo = new ResultVO();
				resVo.setMessage("User already Exist....");
				resVo.setStatus(HttpStatus.OK.value());
				ResponseEntity<ResultVO> response = 
						new ResponseEntity<ResultVO>(resVo, HttpStatus.OK);
				return response;
			}
			User user = new User();
			user.setEmail(regVO.getUserName());
			user.setFirstName(regVO.getFirstName());
			user.setLastName(regVO.getLastName());
			user.setMobileNo(regVO.getMobileNo());
			user.setPassword(regVO.getPassword());
			user.setUserName(regVO.getUserName());
			user.setUserTypeId(regVO.getUserTypeId());
			user.setGender(regVO.getGender());
			user.setIsActive("Y");
			user.setIsDeleted("N");
			user.setProfilePic(fileUpload(regVO.getFile()));
			userRepo.save(user);
			ResultVO resVo = new ResultVO();
			resVo.setMessage("User saved successfully.....");
			resVo.setStatus(HttpStatus.OK.value());
			ResponseEntity<ResultVO> response = 
					new ResponseEntity<ResultVO>(resVo, HttpStatus.OK);
			
		return response;
		
	}
	public ResponseEntity<ResultVO> loginUser(RegistrationVO regVO) {
		List<User> user = userRepo.findByUserNameAndIsActiveAndIsDeleted(regVO.getUserName(), "Y", "N");
		if(user != null && user.size() > 0) {
			if(user.get(0).getPassword().equals(regVO.getPassword())) {
				ResultVO resVo = new ResultVO();
				resVo.setUser(user.get(0));
				resVo.setMessage("User Login Success");
				resVo.setStatus(HttpStatus.OK.value());
				ResponseEntity<ResultVO> response = 
						new ResponseEntity<ResultVO>(resVo, HttpStatus.OK);
				return response;
			}
		}
		ResultVO resVo = new ResultVO();
		resVo.setMessage("User Login Field");
		resVo.setStatus(HttpStatus.NOT_FOUND.value());
		ResponseEntity<ResultVO> response = 
				new ResponseEntity<ResultVO>(resVo, HttpStatus.NOT_FOUND);
		return response;
	}
	public String fileUpload(MultipartFile file) throws IOException {
		String filePath="D:\\";
		File f = new File(filePath+"asserts");
		if(!f.exists()) {
			f.mkdir();
		}
		filePath =filePath+ f.getName();
		f = new File(filePath+"\\"+"profile_images");
		if(!f.exists()) {
			f.mkdir();
		}
		filePath=filePath+"\\"+f.getName();
		f = new File(filePath +"\\"+file.getOriginalFilename() );
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		out.write(file.getBytes());
		out.close();	
		filePath = filePath +"\\"+ file.getOriginalFilename();
		return filePath;
	}
	@ExceptionHandler(IOException.class)
	private ResponseEntity<ResultVO> fileNotFountHandaler(IOException ex) {
		ResultVO resVo = new ResultVO();
		resVo.setMessage(ex.getMessage());
		resVo.setStatus(HttpStatus.BAD_REQUEST.value());

		ResponseEntity<ResultVO> response = 
				new ResponseEntity<ResultVO>(resVo, HttpStatus.BAD_REQUEST);
		return response;
		
	}
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ResultVO> handlerException(Exception ex) {
		ResultVO resVo = new ResultVO();
		resVo.setMessage(ex.getMessage());
		resVo.setStatus(HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ResultVO> response = 
				new ResponseEntity<ResultVO>(resVo, HttpStatus.BAD_REQUEST);
		return response;
		
	}

}

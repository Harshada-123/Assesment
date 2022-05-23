package com.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.Service.LoginService;
import com.login.model.User;



@RestController
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	private LoginService service;
	
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempUsername= user.getUsername();
		if(tempUsername!=null && "".equals(tempUsername)) {
		User userobj = service.fetchUserByEmailId(tempUsername);
		if(userobj!=null) {
			throw new Exception("user with"+tempUsername+" is already exists");
		}
		}
		
		
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUsername = user.getUsername();
		String tempPassword= user.getPassword();
		User userObj=null;
		if(tempUsername !=null && tempPassword !=null) {
		userObj=service.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
 }
		if(userObj==null) {
			throw new Exception("bad credentials");
		}
		 return userObj;
}
}
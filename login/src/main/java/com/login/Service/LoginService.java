package com.login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.Repository.Repository;
import com.login.model.User;



@Service
public class LoginService {

	@Autowired
	private Repository repo;
	public User saveUser(User user) {
		
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String username) {
	return	repo.findByUsername(username);
	}

	public User fetchUserByUsernameAndPassword(String username,String password) {
	return	repo.findByUsernameAndPassword(username, password);
	}
}

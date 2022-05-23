package com.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.User;

public interface Repository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username,String password);
}
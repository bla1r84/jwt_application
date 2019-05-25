package com.blair.jwt.services;

import java.util.List;

import com.blair.jwt.model.User;

public interface UserService {
	
	User save(User user);
	List<User> findAll();
	void delete(Long id);
	User findUser(String username);
	User findById(Long id);
}

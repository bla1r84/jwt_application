package com.blair.jwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blair.jwt.model.User;
import com.blair.jwt.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public List<User> listUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return new User(id);
	}
}
